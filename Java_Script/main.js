// main.js
console.log("\u{1F44B} Welcome to the Community Portal!");

window.addEventListener("load", () => {
  alert("\u{1F389} The page is fully loaded and ready to go!");
});

const events = [
  { name: "Yoga Session", date: "2025-06-10", seats: 10, category: "wellness" },
  { name: "Music Fest", date: "2024-12-01", seats: 0, category: "music" },
  { name: "Art Workshop", date: "2025-07-15", seats: 5, category: "workshop" },
  { name: "Book Club", date: "2025-09-01", seats: 20, category: "literature" }
];

function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  if (event && event.seats > 0) {
    event.seats--;
    console.log(`\u{2705} Registered for ${event.name}`);
  } else {
    console.log(`\u{274C} Cannot register for ${eventName}`);
  }
}

const container = document.getElementById("event-container");

function renderEvents(filter = "all") {
  container.innerHTML = "";
  const filtered = filter === "all" ? events : events.filter(e => e.category === filter);

  filtered.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p><strong>Date:</strong> ${event.date}</p>
      <p><strong>Seats Available:</strong> ${event.seats}</p>
      <button class="register-btn" data-name="${event.name}">Register</button>
    `;
    container.appendChild(card);
  });
}

renderEvents();

document.querySelector("#categoryFilter").addEventListener("change", (e) => {
  renderEvents(e.target.value);
});

document.addEventListener("click", function (e) {
  if (e.target.classList.contains("register-btn")) {
    const name = e.target.dataset.name;
    registerUser(name);
    renderEvents();
  }
});

document.addEventListener("keydown", (e) => {
  if (e.key === "Enter") {
    console.log("\u{1F50D} Searching events...");
  }
});

const form = document.getElementById("registrationForm");
const message = document.getElementById("formMessage");

form.addEventListener("submit", async function (e) {
  e.preventDefault();

  const userData = {
    name: form.elements.username.value,
    email: form.elements.email.value,
    event: form.elements.event.value
  };

  if (!userData.name || !userData.email) {
    message.textContent = "\u{2757} All fields are required.";
    return;
  }

  try {
    message.textContent = "\u{23F3} Submitting...";
    const res = await fetch("https://mockapi.com/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(userData)
    });

    await new Promise(resolve => setTimeout(resolve, 1000));

    if (res.ok) {
      message.textContent = "\u{2705} Registration successful!";
    } else {
      throw new Error("Server error");
    }
  } catch (err) {
    message.textContent = `\u{274C} Failed: ${err.message}`;
  }
});

// jQuery for demonstration
$(document).ready(function () {
  $(".event-card").hide().fadeIn(800);
});
