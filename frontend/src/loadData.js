let SERVER_URL = window.location.href.includes('localhost')?'http://localhost:8080':'https://www.jconf.org';

export function getRemoteObjects() {
    const promise = fetch(SERVER_URL + '/api/conferences');
    return promise.then(
        response => {
             return response.json()
        });
}

export function getRemoteArticle(name) {
    const promise = fetch(SERVER_URL + '/api/post/html/'+name);
    return promise.then(
        response => {
            return response;
        });
}

export function getSpeakerList() {
    const promise = fetch(SERVER_URL + '/api/speaker/list');
    return promise.then(
        response => {
            return response;
        });

}

export function getSpeaker(id) {
    const promise = fetch(SERVER_URL + '/api/speaker/id/' + id);
    return promise.then(
        response => {
            return response;
        });

}

