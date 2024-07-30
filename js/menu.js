

const nav_menuButton = document.getElementById('toggle-menu');
nav_menuButton.addEventListener('click', function(event) {
    event.preventDefault();
    const menu = document.getElementById('main-menu');
    menu.classList.toggle('is-open');
});