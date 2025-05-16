// Données des conseils du coach selon le type de message
/*const coachAdvices = {
positive: [
    "Ca me fait mal au coeur de le dire, mais c'est pas trop mal !",
    "C'est pas complétement un cauchemar, mais j'aimerai me reveiller!",
    "Ouaiiiis, génial.....j'ai envie de vomir !"
    ],
    neutral: [
        "C'est naze, mais peu mieux faire !",
        "Ta vie est tellement ennuyante !",
        "Aussi charismatique qu'un huitre, mais au moins tu ne te noies pas !"
    ],
    negative: [
        "T'es clairement pas le pingouin qui glisse le plus loin !",
        "Tu es un dechet comme on en voit peu !",
        "T'es bien au fond du trou, et tu creuses encore !"
    ]
};*/

 

// Récupération des tâches depuis le localStorage ou initialisation d'un tableau vide
let tasks = JSON.parse(localStorage.getItem('tasks')) || [];

// Sélection des éléments du DOM
const modal = document.getElementById("trash-modal");
const addButton = document.getElementById("input-button");
const coachButton = document.getElementById("coach-button");
const closeBtn = document.querySelector(".close");
const form = document.getElementById("trash-form");
const toast = document.getElementById("toast");

// Chargement initial des tâches existantes
window.addEventListener('DOMContentLoaded', () => {
    tasks.forEach(task => {
        createTaskElement(task.name, task.isNegative);
    });
    updateCounters();
});

// Gestionnaires d'événements pour le modal
addButton.addEventListener('click', () => {
    modal.style.display = "block";
});

closeBtn.addEventListener('click', () => {
    modal.style.display = "none";
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = "none";
    }
});

// Gestion de la soumission du formulaire
form.onsubmit = (e) => {
    e.preventDefault();
    const name = document.getElementById("trash-name").value;
    const isNegative = document.getElementById("is-negative").checked;
    
    addTask(name, isNegative);
    updateCounters();
    
    form.reset();
    modal.style.display = "none";
};

// Fonction d'ajout d'une nouvelle tâche
function addTask(name, isNegative) {
    const task = {
        id: Date.now(),
        name,
        isNegative
    };
    
    // Ajout de la tâche au tableau et sauvegarde dans le localStorage
    tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(tasks));
    
    // Création de l'élément visuel
    createTaskElement(name, isNegative);
}

// Fonction de création de l'élément visuel d'une tâche
function createTaskElement(name, isNegative) {
    const taskElement = document.createElement("div");
    taskElement.className = "task";
    taskElement.innerHTML = `
        <span>${name}</span>
        <div class="task-actions">
            <span class="task-icon">${isNegative ? '🔴' : '🟢'}</span>
            <button class="delete-btn">❌</button>
        </div>
    `;
    
    // Gestion de la suppression d'une tâche
    taskElement.querySelector('.delete-btn').addEventListener('click', () => {
        tasks = tasks.filter(t => t.name !== name);
        localStorage.setItem('tasks', JSON.stringify(tasks));
        taskElement.remove();
        updateCounters();
    });
    
    document.getElementById("tasks-container").appendChild(taskElement);
}

// Mise à jour des compteurs de tâches
function updateCounters() {
    const positiveCount = tasks.filter(t => !t.isNegative).length;
    const negativeCount = tasks.filter(t => t.isNegative).length;
    
    document.getElementById("positive-count").textContent = positiveCount;
    document.getElementById("negative-count").textContent = negativeCount;
}

// Fonction d'affichage du toast
function showToast(message, type) {
    toast.textContent = message;
    toast.className = `toast ${type}`;
    toast.style.display = "block";
    
    // Masquage automatique du toast après 5 secondes
    setTimeout(() => {
        toast.style.display = "none";
    }, 5000);
}

// Gestion du bouton "Conseils du Coach"
coachButton.onclick = () => {
/*const positiveCount = tasks.filter(t => !t.isNegative).length;
const negativeCount = tasks.filter(t => t.isNegative).length;
    const total = positiveCount + negativeCount;
    
    // Vérification s'il y a des tâches
    if (total === 0) {
        showToast("Commencez par ajouter quelques déchets !", "neutral");
        return;
    }
    
    // Détermination du type de conseil
    let adviceType;
    if (positiveCount === negativeCount) {
        adviceType = "neutral";
    } else if (positiveCount > negativeCount) {
        adviceType = "positive";
    } else {
        adviceType = "negative";
    }*/
    
    // Sélection aléatoire d'un conseil et affichage
    /*const advices = coachAdvices[adviceType];*/
    const randomAdvice = trashCoachmsg[Math.floor(Math.random() * advices.length)];
    
    showToast(randomAdvice, adviceType);
};