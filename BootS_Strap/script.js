// script.js
document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("registerForm");
  form.addEventListener("submit", function (e) {
    e.preventDefault();
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    if (name && email) {
      alert(`Thanks, ${name}! We've sent a confirmation to ${email}.`);
      form.reset();
    } else {
      alert("Please complete all fields before submitting.");
    }
  });
});
