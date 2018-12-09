import * as loadData from "../../loadData";

export default class Speakers {

    constructor() {
        this.container = document.getElementById('speakersContainer');
        this.div = document.createElement('div');
        this.speakers = [];
        this.url='http://localhost:8080/api/speaker/id/';

        while (this.container.firstChild) {
            this.container.removeChild(this.container.firstChild);
        }
        this.container.appendChild(this.div);
    };

    init() {
        speakers = [];
        let ul = this.div.appendChild(document.createElement('ul'));
        ul.className = "speaker-list";
        loadData.getSpeakerList()
            .then(
                response => response.json()
                    .then(
                        responseText => {
                            responseText.forEach(
                                value => {
                                    let li = ul.appendChild(document.createElement('li'));
                                    li.className = "speaker-list";
                                    li.addEventListener('click', function(){
                                        Speakers.getSpeaker(value);
                                    });
                                    let a = li.appendChild(document.createElement('a'));
                                    a.setAttribute('href', "#");
                                    li.appendChild(a);
                                    a.appendChild(document.createTextNode(value));


                                }
                            )
                        }
                    ))
    }

   static getSpeaker(id) {
       let speakerContainer = document.getElementById('selectedSpeakerContainer');
       speakerContainer.innerText="";

       loadData.getSpeaker(id)
            .then(response => response.text().then(
                responseText =>
                    speakerContainer.insertAdjacentHTML('afterbegin', responseText)
            ));
    }
}

let speakers = new Speakers().init();
