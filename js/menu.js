

var nav_menuButton = document.getElementById('toggle-menu');
nav_menuButton.addEventListener('click', function(event) {
    event.preventDefault();
    var menu = document.getElementById('main-menu');
    menu.classList.toggle('is-open');
});