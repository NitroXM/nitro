let people = 0;
let total = 0;
let savedEl = document.getElementById("saved-el");
let totalEl = document.getElementById("total-el");
let countEl = document.getElementById("count-el");


async function latestState() {
    let countStr = await getAllCounts(); // countStr is an array of numbers

    if(countStr.length > 0) {
        people = countStr.pop();
    }
    countEl.textContent = people;
    savedEl.textContent = "Previous entries: " + countStr.join(", ");
    total = countStr.reduce((sum, current) => sum + current, 0);
    totalEl.textContent = "Total: " + total;
}

async function incrementPeople() {
    countEl.textContent = ++people;
    await fetch("http://localhost:8080/api/data", {
        method: "POST"
    })
        .catch(error => console.error("Error incrementing count:", error));
}

async function save() {
    savedEl.textContent += ", " + people;
    total += people
    totalEl.textContent = "Total: " + total;
    countEl.textContent = 0;
    people = 0;
    try {
        await fetch("http://localhost:8080/api/data/save", {
            method: "POST"
        });
    } catch (error) {
        console.error("Error saving count:", error);
    }
}

function getAllCounts() {
    return fetch("http://localhost:8080/api/data/return", {
        method: "GET"
    })
        .then(response => response.json()); // вернёт массив чисел: [3, 5, 7]
}


// Связать кнопку с функцией инкремента
document.getElementById("increment-btn").addEventListener("click", incrementPeople);
document.getElementById("save-btn").addEventListener("click", save);

// Получить значение при загрузке
window.addEventListener("load", latestState);

