export default class Footer extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        let shadow = this.attachShadow({mode: "open"});

        this.shadowRoot.innerHTML = `
        <style>
        p {
            background: gainsboro;
            color: darkgray;
            position: absolute;
            height: 2em;
            bottom: 0;
            left:0;
            text-align: center;
            right: 0;
            font-size: 0.8em;
        }
    </style>
`;
        const p = document.createElement('p');
        p.textContent = `Developed by Marco76 using Java 8 and ES6, deployed with Payara.`;
        this.shadowRoot.appendChild(p);
    }

}

customElements.define('app-footer', Footer);