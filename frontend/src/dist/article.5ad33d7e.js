parcelRequire=function(e,r,n,t){var i="function"==typeof parcelRequire&&parcelRequire,o="function"==typeof require&&require;function u(n,t){if(!r[n]){if(!e[n]){var f="function"==typeof parcelRequire&&parcelRequire;if(!t&&f)return f(n,!0);if(i)return i(n,!0);if(o&&"string"==typeof n)return o(n);var c=new Error("Cannot find module '"+n+"'");throw c.code="MODULE_NOT_FOUND",c}p.resolve=function(r){return e[n][1][r]||r},p.cache={};var l=r[n]=new u.Module(n);e[n][0].call(l.exports,p,l,l.exports,this)}return r[n].exports;function p(e){return u(p.resolve(e))}}u.isParcelRequire=!0,u.Module=function(e){this.id=e,this.bundle=u,this.exports={}},u.modules=e,u.cache=r,u.parent=i,u.register=function(r,n){e[r]=[function(e,r){r.exports=n},{}]};for(var f=0;f<n.length;f++)u(n[f]);if(n.length){var c=u(n[n.length-1]);"object"==typeof exports&&"undefined"!=typeof module?module.exports=c:"function"==typeof define&&define.amd?define(function(){return c}):t&&(this[t]=c)}return u}({"I3fQ":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.getRemoteObjects=t,exports.getRemoteArticle=n,exports.getSpeakerList=r,exports.getSpeaker=o;var e=window.location.href.includes("localhost")?"http://localhost:8080":"https://www.jconf.org";function t(){return fetch(e+"/api/conferences").then(function(e){return e.json()})}function n(t){return fetch(e+"/api/post/html/"+t).then(function(e){return e})}function r(){return fetch(e+"/api/speaker/list").then(function(e){return e})}function o(t){return fetch(e+"/api/speaker/id/"+t).then(function(e){return e})}
},{}],"UhP8":[function(require,module,exports) {
"use strict";Object.defineProperty(exports,"__esModule",{value:!0}),exports.default=void 0;var e=t(require("../../loadData"));function t(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var n in e)if(Object.prototype.hasOwnProperty.call(e,n)){var r=Object.defineProperty&&Object.getOwnPropertyDescriptor?Object.getOwnPropertyDescriptor(e,n):{};r.get||r.set?Object.defineProperty(t,n,r):t[n]=e[n]}return t.default=e,t}function n(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function r(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}function i(e,t,n){return t&&r(e.prototype,t),n&&r(e,n),e}var o=function(){function t(){for(n(this,t),console.log("constructor"),this.container=document.getElementById("articleContainer"),this.div=document.createElement("div");this.container.firstChild;)this.container.removeChild(this.container.firstChild);this.container.appendChild(this.div)}return i(t,[{key:"init",value:function(){var t=this;console.log("init"),window.onload=function(e){return console.log("load",e)},e.getRemoteArticle("2018-12-05-jconf").then(function(e){return e.text().then(function(e){t.div.insertAdjacentHTML("afterbegin",e)})})}}]),t}();exports.default=o;var a=(new o).init();
},{"../../loadData":"I3fQ"}]},{},["UhP8"], null)
//# sourceMappingURL=/article.5ad33d7e.map