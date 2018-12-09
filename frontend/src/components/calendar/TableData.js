export default class TableData {
    constructor() {

    }

    setColumns(columns) {
        this.columns = columns;
    }

    getColumns() {
        return this.columns;
    }

    setContent(json){
        this.content = json;
    }
}