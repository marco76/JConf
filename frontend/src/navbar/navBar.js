const element = name => document.createElement(name);

export default class NavBar {
    constructor() {
        const shadow = document.querySelector("av-navbar");

        const template = element('div');
        template.innerHTML = `
            <div class="navbar">
            <a class="active" href="#"><i class="fa fa-fw fa-home"></i> Home</a>
            <a href="#"><i class="fa fa-fw fa-search"></i> Search</a>
            <a href="#"><i class="fa fa-fw fa-envelope"></i> Contact</a>
            <a href="#"><i class="fa fa-fw fa-user"></i> Login</a>
            </div>`;

        // Create some CSS to apply to the shadow dom
        let style = element("style");

        style.innerText = `
/* Navbar links */
.navbar a {
float: left;
text-align: center;
padding: 12px;
color: white;
text-decoration: none;
font-size: 17px;
}

/* Navbar links on mouse-over */
.navbar a:hover {
background-color: #000;
}

/* Current/active navbar link */
.active {
background-color: #4CAF50;
}

/* Add responsiveness - will automatically display the navbar vertically instead of horizontally on screens less than 500 pixels */
    @media screen and (max-width: 500px) {
        .navbar a {
            float: none;
            display: block;
        }
}`;


        shadow.attachShadow({mode: "open"});
        shadow.shadowRoot.appendChild(style);
        shadow.shadowRoot.appendChild(template);


    }
}

customElements.define("av-navbar", NavBar);
