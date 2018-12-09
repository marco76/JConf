export default class Menu extends HTMLElement {
    constructor() {
        super();
        this.menuList = [{title: 'conferences', page: 'index.html'},
            {title: 'speakers', page: './page/speakers.html'},
            {title: 'article', page:'./page/article.html'},
            {title: 'tips', page:'./page/speakers-tips.html'}
            ];
    }

    connectedCallback() {
       // let shadow = this.attachShadow({mode: "open"});

        let appMenu = document.querySelector('app-menu');
        const selected = appMenu.getAttribute('selected');
        const title = appMenu.getAttribute('title');
        const color = appMenu.getAttribute('color');

        let element = document.createElement('span');
        element.innerHTML = `
        <style>
            :root {
                  --header-background: ${color};
            }
        </style>
       
        <ul class="menu">
             <li class="title menu-title">
                <i class="fab fa-java"></i> ${title} <i class="fab fa-js"> </i>
             </li>
             
             ${this.menuList.map(menu =>
                  menu.title !== selected ? `
                <li class="menu-item">
                     <a href="${menu.page}">${menu.title}</a>
                </li>` : ``
                    ).join('')}
                </ul>`;
        document.querySelector('header').appendChild(element);
    }



}

customElements.define('app-menu', Menu);