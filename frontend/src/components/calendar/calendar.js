import TableData from "./TableData";
import * as loadData from "../../loadData";

let options = {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'};
let dateTimeFormat = new Intl.DateTimeFormat('de-DE');

export default class Calendar {


    constructor(tableId) {
        this.container = document.getElementById('tableContainer');

        this.tableData = new TableData();
        this.tableData.setColumns([{name: 'name', link: 'website'},
            {name: 'begin', format: 'date'},
            {name: 'end', format: 'date'},
            {name: 'city'},
            {name: 'isoCountry', label:' ', format: 'flag'},
            {name: 'country'},

            {name: 'cfp', format: 'date'}]);
        this.table = document.createElement('table');

        while (this.container.firstChild) {
            this.container.removeChild(this.container.firstChild);
        }
        this.container.appendChild(this.table);

    };

    init() {
        window.onload = e => console.log("load", e);

        let dataLoaded = loadData.getRemoteObjects();
        this.buildTable(dataLoaded);
    }

    buildTable(dataLoaded) {
        let thead = this.table.createTHead();
        let row = thead.insertRow();


        this.tableData.getColumns().forEach(
            column => {
                let cell = row.insertCell();
                cell.appendChild(document.createTextNode(column.label ? column.label : column.name));
                cell.className = 'table-' + column.format + ' ' + 'table-row-'+column.name;
            });


        dataLoaded.then(
            data =>
                this.buildRows(data)
        )
    }

    buildRows(data) {
        let tbody = this.table.createTBody();
        data.forEach(
            value => {
                let row = tbody.insertRow();
                this.tableData.getColumns().forEach(
                    column => {
                        let cell = row.insertCell();
                        // Append a text node to the cell
                        let text = (value[column.name]);

                        if (column.format && column.format === 'date') {
                            if (text) {
                                text = dateTimeFormat.format(new Date(text), options);
                            } else {
                                text = '';

                            }
                            cell.className = 'table-' + column.format + ' ';
                            cell.appendChild(document.createTextNode(text));
                        } else if (column.format && column.format === 'flag') {
                            let span = document.createElement('span');
                            cell.appendChild(span);
                            span.className = "flag-icon flag-icon-" + text;
                        } else {
                            if (column.link) {
                                let a = document.createElement('a');
                                a.setAttribute('href', value[column.link]);
                                cell.appendChild(a);
                                a.appendChild(document.createTextNode(text));
                            } else {
                                cell.appendChild(document.createTextNode(text));
                            }
                        }
                        cell.className += "col-" + column.name;

                    }
                )


            })
    }

}
let index = new Calendar().init();
