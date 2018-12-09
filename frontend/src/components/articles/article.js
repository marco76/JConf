import * as loadData from "../../loadData";

export default class Article {

    constructor() {
        console.log('constructor');
        this.container = document.getElementById('articleContainer');
        this.div = document.createElement('div');

        while (this.container.firstChild) {
            this.container.removeChild(this.container.firstChild);
        }
        this.container.appendChild(this.div);
    };

    init() {
        console.log('init');
        window.onload = e => console.log("load", e);
        loadData.getRemoteArticle("2018-12-05-jconf")
            .then(
                response => response.text()
                    .then(
                        responseText => {
                            this.div.insertAdjacentHTML('afterbegin', responseText);
                        }
                    ))
    }
}

let article = new Article().init();
