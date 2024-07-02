
// const info_field = document.querySelector('#info_field');
// info_field.innerHTML = `<address></address><p id="copyright"><small></small></p>`;

const footer = document.querySelector("footer");
const template = document.querySelector("#tpl_footer");

const clone = template.content.cloneNode(true);
let addr = clone.querySelector('address');
let copyright = clone.querySelector('small');
addr.textContent = "TEL: 0120-XXX-001 FAX 0120-XXX-002";
copyright.textContent = "Copyright 2024 XXXXX All rights reserved.";

footer.appendChild(clone);