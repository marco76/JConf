export default class CommonHead extends HTMLElement{
    constructor() {
        super();
    }

    connectedCallback() {

        this.attachShadow({mode: "open"});
        this.shadowRoot.innerHTML= ``
    }

}

customElements.define('app-common-head', CommonHead);