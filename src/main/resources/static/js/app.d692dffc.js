(function(e){function t(t){for(var s,a,i=t[0],c=t[1],l=t[2],u=0,m=[];u<i.length;u++)a=i[u],Object.prototype.hasOwnProperty.call(o,a)&&o[a]&&m.push(o[a][0]),o[a]=0;for(s in c)Object.prototype.hasOwnProperty.call(c,s)&&(e[s]=c[s]);d&&d(t);while(m.length)m.shift()();return r.push.apply(r,l||[]),n()}function n(){for(var e,t=0;t<r.length;t++){for(var n=r[t],s=!0,a=1;a<n.length;a++){var i=n[a];0!==o[i]&&(s=!1)}s&&(r.splice(t--,1),e=c(c.s=n[0]))}return e}var s={},a={app:0},o={app:0},r=[];function i(e){return c.p+"js/"+({chat:"chat",login:"login"}[e]||e)+"."+{chat:"d6c1f44d",login:"42f04a7b"}[e]+".js"}function c(t){if(s[t])return s[t].exports;var n=s[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={chat:1,login:1};a[e]?t.push(a[e]):0!==a[e]&&n[e]&&t.push(a[e]=new Promise((function(t,n){for(var s="css/"+({chat:"chat",login:"login"}[e]||e)+"."+{chat:"17c12dc2",login:"9c9cfc0b"}[e]+".css",o=c.p+s,r=document.getElementsByTagName("link"),i=0;i<r.length;i++){var l=r[i],u=l.getAttribute("data-href")||l.getAttribute("href");if("stylesheet"===l.rel&&(u===s||u===o))return t()}var m=document.getElementsByTagName("style");for(i=0;i<m.length;i++){l=m[i],u=l.getAttribute("data-href");if(u===s||u===o)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var s=t&&t.target&&t.target.src||o,r=new Error("Loading CSS chunk "+e+" failed.\n("+s+")");r.code="CSS_CHUNK_LOAD_FAILED",r.request=s,delete a[e],d.parentNode.removeChild(d),n(r)},d.href=o;var h=document.getElementsByTagName("head")[0];h.appendChild(d)})).then((function(){a[e]=0})));var s=o[e];if(0!==s)if(s)t.push(s[2]);else{var r=new Promise((function(t,n){s=o[e]=[t,n]}));t.push(s[2]=r);var l,u=document.createElement("script");u.charset="utf-8",u.timeout=120,c.nc&&u.setAttribute("nonce",c.nc),u.src=i(e);var m=new Error;l=function(t){u.onerror=u.onload=null,clearTimeout(d);var n=o[e];if(0!==n){if(n){var s=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;m.message="Loading chunk "+e+" failed.\n("+s+": "+a+")",m.name="ChunkLoadError",m.type=s,m.request=a,n[1](m)}o[e]=void 0}};var d=setTimeout((function(){l({type:"timeout",target:u})}),12e4);u.onerror=u.onload=l,document.head.appendChild(u)}return Promise.all(t)},c.m=e,c.c=s,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var s in e)c.d(n,s,function(t){return e[t]}.bind(null,s));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],u=l.push.bind(l);l.push=t,l=l.slice();for(var m=0;m<l.length;m++)t(l[m]);var d=u;r.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"0c55":function(e,t,n){e.exports=n.p+"img/contacto.323bd7a0.png"},"1f81":function(e,t,n){"use strict";var s=n("f8f5"),a=n.n(s);a.a},2593:function(e,t,n){},"28ab":function(e,t,n){e.exports=n.p+"img/buscar.588dd1fb.png"},"2bb0":function(e,t,n){"use strict";var s=n("ab56"),a=n.n(s);a.a},"2ce7":function(e,t,n){},"30f4":function(e,t,n){},"32d8":function(e,t,n){"use strict";var s=n("4196"),a=n.n(s);a.a},"33d2":function(e,t,n){"use strict";var s=n("b148"),a=n.n(s);a.a},"36c6":function(e,t,n){},"3a79":function(e,t,n){"use strict";var s=n("f826"),a=n.n(s);a.a},"3f75":function(e,t,n){},4196:function(e,t,n){},4556:function(e,t,n){e.exports=n.p+"img/enviar.5598a35f.png"},5515:function(e,t,n){"use strict";var s=n("8076"),a=n.n(s);a.a},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var s=n("2b0e"),a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("Snackbar"),n("router-view")],1)},o=[],r=(n("96cf"),n("1da1")),i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("transition",{attrs:{name:"fade-fast"}},[n("div",{directives:[{name:"show",rawName:"v-show",value:1==e.mostrarSnackbar,expression:"mostrarSnackbar == true"}],staticClass:"snackbar"},[n("p",{staticClass:"snackbar-texto"},[e._v(" "+e._s(e.texto)+" ")])])])},c=[],l={components:{},props:{},data:function(){return{mostrarSnackbar:!1,texto:"",myTimeout:null}},created:function(){var e=this;this.$eventHub.$on("snackbar",(function(t){return e.abrirSnackbar(t)}))},mounted:function(){},methods:{abrirSnackbar:function(e){clearTimeout(this.myTimeout),this.texto=e,this.mostrarSnackbar=!0;var t=this;this.myTimeout=setTimeout((function(){t.mostrarSnackbar=!1}),2e3)}}},u=l,m=(n("d981"),n("2877")),d=Object(m["a"])(u,i,c,!1,null,null,null),h=d.exports,f={data:function(){return{deferredPrompt:null}},components:{Snackbar:h},created:function(){var e=this;s["a"].prototype.$localurl="http://10.120.17.157:8080",this.$axios.defaults.headers.common["Authorization"]="Bearer "+localStorage.getItem("$token"),null==localStorage.getItem("$token")&&this.$router.push("/login"),s["a"].prototype.$isMobile=this.isMobile(),window.addEventListener("beforeinstallprompt",(function(t){t.preventDefault(),e.deferredPrompt=t})),window.addEventListener("appinstalled",(function(){e.deferredPrompt=null}))},mounted:function(){},methods:{dismiss:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.deferredPrompt=null;case 1:case"end":return t.stop()}}),t)})))()},install:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.deferredPrompt.prompt();case 1:case"end":return t.stop()}}),t)})))()},isMobile:function(){return!!/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)&&!(screen.width>500)}}},v=f,g=(n("1f81"),n("b78c"),n("5515"),n("60d4"),n("e1ab"),Object(m["a"])(v,a,o,!1,null,null,null)),p=g.exports,b=(n("d3b7"),n("8c4f")),j=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"home"},[s("div",{staticClass:"home-body"},[s("div",{staticClass:"home-left"},[s("div",[s("input",{ref:"inputBuscar",staticClass:"home-buscar",attrs:{type:"text",placeholder:"Buscar"},on:{keyup:function(t){return e.buscar()}}}),s("img",{staticClass:"home-buscar-img",attrs:{src:n("28ab")}})]),s("div",{staticClass:"home-left-conversaciones"},e._l(e.conversacionesFiltradas,(function(t,n){return s("div",{key:n,class:{"home-conversacion-elegida":t==e.conversacionElegida},on:{click:function(n){return e.elegirConversacion(t)}}},[s("Conversacion",{attrs:{conversacion:t}})],1)})),0),s("button",{staticClass:"home-logout",on:{click:function(t){return e.logout()}}},[e._v("Cerrar sesión")])]),s("div",{directives:[{name:"show",rawName:"v-show",value:!e.$isMobile,expression:"!$isMobile"}],staticClass:"home-right"},[null!=e.conversacionElegida?s("Chat",{attrs:{conversacion:e.conversacionElegida,contactos:e.contactos}}):e._e()],1)])])},w=[],A=(n("4de4"),n("c975"),n("b0c0"),n("ac1f"),n("25f0"),n("1276"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"conversacion"},[n("div",{directives:[{name:"show",rawName:"v-show",value:e.conversacion.ammount_no_read>0,expression:"conversacion.ammount_no_read > 0"}],staticClass:"conversacion-sinleer"},[n("label",[e._v(e._s(e.conversacion.ammount_no_read))])]),e._m(0),n("p",{staticClass:"conversacion-nombre"},[e._v(e._s(null!=e.conversacion.conversation_name?e.conversacion.conversation_name:e.conversacion.conversation_members[0].name))]),n("p",{staticClass:"conversacion-email"},[e._v(e._s(e.conversacion.conversation_members.length>1?e.conversacion.conversation_members.length+" miembros":""))])])}),C=[function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"conversacion-imagen"},[s("img",{attrs:{src:n("0c55")}})])}],M={data:function(){return{}},props:{conversacion:[Object]},computed:{},mounted:function(){},created:function(){},methods:{}},_=M,I=(n("2bb0"),Object(m["a"])(_,A,C,!1,null,"2731537e",null)),y=I.exports,x=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"chat"},[s("div",{staticClass:"chat-top"},[s("p",[e._v(e._s(null!=e.conversacion.conversation_name?e.conversacion.conversation_name+e.getMiembros():e.conversacion.conversation_members[0].name))])]),s("div",{ref:"chatScroll",staticClass:"chat-scroll",attrs:{id:"chatScroll"},on:{scroll:e.onScroll}},e._l(e.mensajes,(function(t){return s("div",{key:t.message_id,staticClass:"chat-container",class:{"chat-mensaje-propio":t.sender_id==e.userId},attrs:{id:t.message_id}},[null!=t.fecha?s("div",{staticClass:"chat-separador"},[s("label",[e._v(e._s(t.fecha))])]):e._e(),null==t.fecha?s("div",[t.sender_id!=e.userId?s("span",{staticClass:"chat-tail"},[s("svg",{staticStyle:{display:"block"},attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 8 13",width:"8",height:"13"}},[s("path",{attrs:{opacity:".13",fill:"#0000000",d:"M1.533 3.568L8 12.193V1H2.812C1.042 1 .474 2.156 1.533 3.568z"}}),s("path",{attrs:{fill:"currentColor",d:"M1.533 2.568L8 11.193V0H2.812C1.042 0 .474 1.156 1.533 2.568z"}})])]):e._e(),t.sender_id==e.userId?s("span",{staticClass:"chat-tail-out"},[s("svg",{staticClass:"chat-tail-svg",staticStyle:{display:"block"},attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 8 13",width:"8",height:"13"}},[s("path",{attrs:{opacity:".13",d:"M5.188 1H0v11.193l6.467-8.625C7.526 2.156 6.958 1 5.188 1z"}}),s("path",{attrs:{fill:"currentColor",d:"M5.188 0H0v11.193l6.467-8.625C7.526 1.156 6.958 0 5.188 0z"}})])]):e._e(),null!=t.message_type&&"TextMessage"==t.message_type.substr(11,100)?s("MensajeTexto",{attrs:{mensaje:t,sender:e.getSender(t)}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esArchivo(t)?s("MensajeArchivo",{attrs:{mensaje:t,sender:e.getSender(t)}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esImagen(t)?s("MensajeImagen",{attrs:{mensaje:t,sender:e.getSender(t)}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esVideo(t)?s("MensajeVideo",{attrs:{mensaje:t,sender:e.getSender(t)}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esAudio(t)?s("MensajeAudio",{attrs:{mensaje:t,sender:e.getSender(t)}}):e._e()],1):e._e()])})),0),s("div",{staticClass:"chat-bottom"},[s("div",{staticClass:"chat-adjuntar",attrs:{title:"Adjuntar"},on:{click:function(t){return e.adjuntar()}}},[s("input",{ref:"adjuntoFiles",staticClass:"app-hide",attrs:{type:"file",multiple:""},on:{change:function(t){return e.changeAdjunto()}}}),s("img",{attrs:{src:n("57bf")}})]),s("input",{ref:"inputTexto",attrs:{type:"text",placeholder:"Escribe un mensaje aquí",maxlength:"140"},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.enviar()}}}),s("img",{staticClass:"chat-enviar",attrs:{src:n("4556")},on:{click:function(t){return e.enviar()}}})])])},S=[],T=(n("99af"),n("c740"),n("4160"),n("caad"),n("45fc"),n("a434"),n("159b"),n("b620")),k=n("901b"),O=n("8a60"),E=n("b1af"),B=n("ff3b"),D={name:"Chat",components:{MensajeTexto:T["a"],MensajeArchivo:k["a"],MensajeImagen:O["a"],MensajeVideo:E["a"],MensajeAudio:B["a"]},data:function(){return{mensajes:[],userId:null,primeraPagina:!0,currentPage:0,lastPage:0,mensajeOffset:null,actualizarTimer:null}},props:{conversacion:[Object],contactos:[Array]},computed:{},mounted:function(){var e=this;this.$eventHub.$on("chat-update",(function(){return e.getChat(null,!0)})),this.userId=localStorage.getItem("$userId"),this.getChat(null,!0),this.mensajes=[],this.$refs.chatScroll.addEventListener("touchmove",this.onScroll)},created:function(){var e=this;this.$eventHub.$on("chat-get",(function(t){return e.getChat(t,!0)}))},methods:{actualizar:function(){var e=this;clearTimeout(this.actualizarTimer),this.actualizarTimer=setTimeout((function(){e.getChat(null,!1),e.actualizar()}),3e3)},getSender:function(e){var t=localStorage.getItem("$userId"),n=null!=this.conversacion.conversation_name?this.conversacion.conversation_members[this.conversacion.conversation_members.findIndex((function(t){return t.user_id==e.sender_id}))].user_id:null;return null!=n&&n!=t?this.contactos.filter((function(e){return e.id==n}))[0].email:null},esImagen:function(e){var t=e.message.file.split(".")[e.message.file.split(".").length-1].toLowerCase();return"png"==t||"jpg"==t||"svg"==t||"jpeg"==t},esVideo:function(e){var t=e.message.file.split(".")[e.message.file.split(".").length-1].toLowerCase();return"webm"==t||"mkv"==t||"flv"==t||"mp4"==t||"mov"==t||"avi"==t},esAudio:function(e){var t=e.message.file.split(".")[e.message.file.split(".").length-1].toLowerCase();return"m4a"==t||"qt"==t||"4mb"==t},esArchivo:function(e){return 0==this.esImagen(e)&&0==this.esVideo(e)&&0==this.esAudio(e)},getChat:function(e,t){null==e?e=this.conversacion.conversation_id:(this.mensajes=[],this.primeraPagina=!0);var n=localStorage.getItem("$userId"),s=this;this.$axios.get(this.$localurl+"/api/"+n+"/conversations/"+e+"?page=0").then((function(e){1!=s.primeraPagina||s.isOverflown(document.getElementById("chatScroll"))||(s.primeraPagina=!1,s.getChatPage(2));var n=!1;s.lastPage=e.data.messages.last_page,e.data.messages.data.reverse(),e.data.messages.data.forEach((function(e){s.mensajes.some((function(t){return null!=t.message&&t.message_id==e.message_id}))||e.conversation_id!=s.conversacion.conversation_id||(s.mensajes.push(e),n=!0)})),1==n&&(s.mensajeOffset=s.mensajes[s.mensajes.length-1]),s.getSeparadores(t)})).catch((function(e){clearTimeout(s.actualizarTimer),null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login"))}))},getChatPage:function(e){this.mensajeOffset=this.mensajes[0],null!=this.mensajeOffset&&null==this.mensajeOffset.message_id&&(this.mensajeOffset=this.mensajes[1]);var t=localStorage.getItem("$userId");this.currentPage=e;var n="";null!=e&&(n="?page="+e);var s=this;this.$axios.get(this.$localurl+"/api/"+t+"/conversations/"+this.conversacion.conversation_id+n).then((function(e){e.data.messages.data.reverse(),s.mensajes=e.data.messages.data.concat(s.mensajes),s.getSeparadores(!0)})).catch((function(e){null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login"))}))},getSeparadores:function(e){var t=this,n=[];this.mensajes=this.mensajes.filter((function(e){return null==e.fecha}));for(var s=this.mensajes.length,a=0;a<s;a++){var o,r,i,c=this.mensajes[a];if(null!=c.created_at)(function(){o=new Date(c.created_at),o.setHours(o.getHours()+3);var e=o.getDate(),l=o.getMonth()+1,u=o.getFullYear(),m=e+"/"+l+"/"+u;r=new Date;var d=r.getDate(),h=r.getMonth()+1,f=r.getFullYear();e!=d||l!=h||u!=f?0==n.includes(m)&&(i=["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"],m=i[o.getDay()]+" "+m,t.mensajes.some((function(e){return e.fecha==m}))||(t.mensajes.splice(a,0,{fecha:m}),s++)):t.mensajes.some((function(e){return"HOY"==e.fecha}))||(t.mensajes.splice(a,0,{fecha:"HOY"}),s++)})()}if(1==e){var l=this;this.$nextTick((function(){l.scrollToBottom()}))}},onScroll:function(){var e=this.$refs.chatScroll;e.scrollTop<.1*e.clientHeight&&this.currentPage<this.lastPage&&(this.offset=this.offset+this.limit,this.currentPage++,this.getChatPage(this.currentPage))},scrollToBottom:function(){var e=this;this.$nextTick((function(){null!=e.mensajeOffset&&(null!=document.getElementById(e.mensajeOffset.message_id)?document.getElementById("chatScroll").scrollTop=document.getElementById(e.mensajeOffset.message_id).offsetTop:setTimeout((function(){e.scrollToBottom()}),200))}))},enviar:function(){this.scrollToBottom();var e=this.$refs.inputTexto.value;if(""!=e){this.$refs.inputTexto.value="";var t=localStorage.getItem("$userId"),n={user_id:t,message:e,conversation_id:this.conversacion.conversation_id,conversation_members:this.conversacion.conversation_members},s=this;this.$axios.post(this.$localurl+"/api/v1/messages/textMessage",n).then((function(){s.getChat(null,!0)})).catch((function(e){null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login")),alert("Se produjo un error, reintente")}))}},isOverflown:function(e){return e.scrollHeight>e.clientHeight||e.scrollWidth>e.clientWidth},adjuntar:function(){this.$refs.adjuntoFiles.click()},changeAdjunto:function(){if(this.$refs.adjuntoFiles.files.length>0){var e=localStorage.getItem("$userId"),t=new FormData;t.append("message","archivos"),t.append("user_id",e),t.append("conversation_id",this.conversacion.conversation_id),this.$refs.adjuntoFiles.files.forEach((function(e,n){t.append("file["+n+"]",e)}));var n=this;this.$axios.post(this.$localurl+"/api/v1/messages/fileMessage",t).then((function(e){n.getChat(null,!0),null!=e&&null!=e.data&&null!=e.data.messages_with_error&&n.mostrarErroresArchivos(e.data.messages_with_error)})).catch((function(e){null!=e&&401==e.status?(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&n.$router.push("/login")):null!=e&&null!=e.data&&400==e.status&&null!=e.data.messages_with_error&&n.mostrarErroresArchivos(e.data.messages_with_error)}))}},mostrarErroresArchivos:function(e){var t="";e.forEach((function(e){t=t+"archivo: "+e.original_file+" error: "+e.text_error+", "})),t=t.substr(0,t.length-2),console.log(t),alert(t)},getMiembros:function(){var e="",t=this;if(this.conversacion.conversation_members.length>1)return e=" (",this.conversacion.conversation_members.forEach((function(n){e=e+t.contactos.filter((function(e){return e.id==n.user_id}))[0].email+", "})),e=e.substr(0,e.length-2)+")",e}}},G=D,H=(n("32d8"),Object(m["a"])(G,x,S,!1,null,"3bba59f8",null)),Z=H.exports,N=n("cc7d"),Y=n.n(N),L=n("c6e1"),R=n.n(L),P={name:"Home",components:{Conversacion:y,Chat:Z},data:function(){return{conversacionElegida:null,conversacionesFiltradas:[],conversaciones:[],mensajes:[],contactos:[],stompClient:null,count:0}},mounted:function(){this.$isMobile&&(this.mostrarChat=!1),this.getConversaciones(),this.getContactos(),this.conectarWebSocket()},methods:{conectarWebSocket:function(){var e=new Y.a(this.$localurl+"/websocket");this.stompClient=R.a.over(e),this.stompClient.debug=function(){};var t=this;this.stompClient.connect({},(function(e){console.log("Connected: "+e),t.stompClient.subscribe("/notificacion/mensaje/"+localStorage.getItem("$userId"),(function(e){console.log("subscribe"),console.log(e),t.getConversaciones(),t.$eventHub.$emit("chat-update")}))}))},desconectarWebSocket:function(){null!=this.stompClient&&this.stompClient.disconnect(),console.log("Disconnected")},sendMessage:function(e,t){console.log("sendMessage");var n={from:e,text:t.toString()};this.stompClient.send("/app/chat",JSON.stringify(n),{})},showMessageOutput:function(e){console.log("showMessageOutput"),console.log(e)},getConversaciones:function(){var e=localStorage.getItem("$userId"),t=this;this.$axios.get(this.$localurl+"/api/"+e+"/conversations/").then((function(e){t.conversaciones=e.data.conversations,t.conversacionesFiltradas=t.conversaciones})).catch((function(e){null==e||401!=e.response.status&&400!=e.response.status||(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&t.$router.push("/login"))}))},getContactos:function(){var e=this;this.$axios.get(this.$localurl+"/api/usuarios").then((function(t){e.contactos=t.data})).catch((function(t){null==t||401!=t.response.status&&400!=t.response.status||(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&e.$router.push("/login"))}))},buscar:function(){var e=this.$refs.inputBuscar.value.toUpperCase();this.conversacionesFiltradas=this.conversaciones.filter((function(t){return t.user_dest.name.toUpperCase().indexOf(e)>-1||t.user_dest.email.toUpperCase().indexOf(e)>-1}))},elegirConversacion:function(e){e.ammount_no_read=0,this.$isMobile&&this.$router.push("/chat/"+e.conversation_id+"/"+e.user_dest.id),this.conversacionElegida=e,s["a"].prototype.$conversacionElegida=e,this.$eventHub.$emit("chat-get",e.conversation_id)},logout:function(){localStorage.removeItem("$token"),localStorage.removeItem("$userId"),localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&this.$router.push("/login")}}},F=P,$=(n("8361"),Object(m["a"])(F,j,w,!1,null,"423f1212",null)),W=$.exports;s["a"].use(b["a"]);var z=[{path:"/",name:"Home",component:W},{path:"/login",name:"login",component:function(){return n.e("login").then(n.bind(null,"a55b"))}},{path:"/chat/:id/:user_dest_id",name:"chat",component:function(){return n.e("chat").then(n.bind(null,"293a"))}}],J=new b["a"]({mode:"history",base:"/",routes:z}),Q=J,U=n("bc3a"),V=n.n(U),X=n("9483");Object(X["a"])("".concat("/","service-worker.js"),{ready:function(){console.log("App is being served from cache by a service worker.\nFor more details, visit https://goo.gl/AFskqB")},registered:function(){console.log("Service worker has been registered.")},cached:function(){console.log("Content has been cached for offline use.")},updatefound:function(){console.log("New content is downloading.")},updated:function(){console.log("New content is available; please refresh.")},offline:function(){console.log("No internet connection found. App is running in offline mode.")},error:function(e){console.error("Error during service worker registration:",e)}}),s["a"].config.productionTip=!1,s["a"].prototype.$eventHub=new s["a"],s["a"].prototype.$axios=V.a,new s["a"]({router:Q,render:function(e){return e(p)}}).$mount("#app")},"57bf":function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAACXBIWXMAAC4jAAAuIwF4pT92AAAFFmlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNi4wLWMwMDIgNzkuMTY0NDg4LCAyMDIwLzA3LzEwLTIyOjA2OjUzICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgMjIuMCAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDIwLTEyLTE2VDA5OjU3OjI5LTAzOjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMC0xMi0xNlQxMDozMjo0Ny0wMzowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMC0xMi0xNlQxMDozMjo0Ny0wMzowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHBob3Rvc2hvcDpDb2xvck1vZGU9IjMiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpmYTBlZjYyNi05MzNlLWViNDMtOWRiZC01MDU1YTEwMzI0Y2MiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6ZmEwZWY2MjYtOTMzZS1lYjQzLTlkYmQtNTA1NWExMDMyNGNjIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9InhtcC5kaWQ6ZmEwZWY2MjYtOTMzZS1lYjQzLTlkYmQtNTA1NWExMDMyNGNjIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0iY3JlYXRlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDpmYTBlZjYyNi05MzNlLWViNDMtOWRiZC01MDU1YTEwMzI0Y2MiIHN0RXZ0OndoZW49IjIwMjAtMTItMTZUMDk6NTc6MjktMDM6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCAyMi4wIChXaW5kb3dzKSIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6214moAAAIl0lEQVR4nO2deaxdUxSHv3f7tIoO1FClSqMpNbSUKqVUCVLV1phW2j60CG1EDEUEMYQgKlRiLtHWH6YWaWKKGhrUUENDeU/UVBUS99UQQfr8se7RY9919hnucM7Z937JS/vWPlPe76z1O8M+e7d0dXXRJDsU0j6AJv+nKUjGaD3yhjfTPoa8cihwGHAgMADYphTvBNYDHwLvAm8Df0fdaGtVD9F9ugMXAGcD+4UsO7307/fAc8BCYFXYDpolKzrTgHZgPuFi+NkFOB94B3gGGG5buClINB4BFgO7VbidyUgpuyJogaYgdnojZ/bMKm/3ZkTgMpoeEkxfxJT3tCzzKvACsBpYB/wD9AGGAIcDkwjOqmnA1kjW/EfL2OvfSH7I7tIPMeDBAe3LgFuQKygbrcCZwHXA7gHL3ArM835plqxytsMuxjnIWR0mBkjGPAoMBe4PWOZy5BIaaApisi1SpjQx/kbuOx5OsN2/gPOAqwLaH/X+46og45H6/iZwdMR1+gHvo4vRCYwC3qrwuG4GblfiQ4CJ4KYgM4GXgaOAMcArwIiQdfoiZWoPpW0jcDByuVoNLgPWKPErwT1BZiL3DCaTLevYMqMIHITcEFaTGUrsUGCgS4IEiQGSMRo2A/fKVLXFALlM1i4KJrgiSBvBYtyBeImJzcA7kTJVCzE8HlFih7kgyEzkwZ3GAuASJZ5GmTJZqcSG5V0QW5m6B5irxPtiN/BRQEcVji2Mr4DfjNhueRYkTIw5SjwLmeHxO/CTEdsqr4IkESMtAw+iBehhBvMoSBvxxUjbwDV2AHYyYpvyJkiYgWe9TPnZB+hmxDbkSZA8G7jGCUrss7wIkncD1zhLib2RB0FcMHCTC4DtlfhTWRekDTcM3E9f4E4lvgL4KsuCuGTgfpYDWyjxSyG7l72uGbjHE/jeDvp4EjmRMimIiwYO0svkVCX+K75eLVnrdeKigQMsAaYGtB0H/OH9kqUMacM9Awe7GNMwXgtnJUPCDFzzjH6IGJpnFBExquUZfZATYhNwF/JgMAo2Mc4HHjeDWRAk6wY+FLkk7V/6fRZwQGk/NmxizAHu0xrSLllZN/ChiPD9fbHBwOkh6y3GLsY9QSummSFZN3BPjN5Km61k2TJjLhYxIL0MaSPbBj60tC9NjFXAUwHrhYmxIGzHaWRI1g3cy4xeStsHwFikJ6KJTYzZwINRdl5vQfJg4O+x+fM0P6uB0eifp9nEmAE8FvUA6lmy8mLgccWwGXgsMaB+GZJnA18NHEKNM8OjHhnSRn4NvC5lyk+tBcn6I/QwAx9NfAOfTkIxoLYlq1ENfFElB1WrDEniGVsiHZAbxsA1apEhScV4B/lDmThr4BrVzpA24ovRHcmM/ZU2pw1co5qCJDHwLZGzVRvdoIjjBq5RrZKVxMB7IGVKy4yGMHCNamRIJZ6hiVGkQQxco9IMqbYYDWXgGpUIMoN8GLjmGWvIgIFrJC1ZU/B97G6QdQPvQD6XTt3ANZJkyBTg6YC2rBt4ByK89j687gauETdDwsTIsoG3IyWxU2lLxcA14mTIJOKLYcuMehp4R2lfRaUtVc8wiSpIkswAeJ30DbwDGEmyMlVXMSBaybKJEWTgIONJjVLiRepr4KOIL0ZdDFwjLEOSGDjIYF3zlHgaBq55RiYMXMOWIUnLFMC1AfHRNA3cSlCGnEhyMXoCZyjxWcBn0Q/NihMGrqEJMgIZ+FcjTAyQfks9jdgXwEOxjiwYZwxcwyxZPZABvzRsBu5nhBILuquPi1MGrmFmyCKk+43JQoIN3GQXJfZRnIMKwDkD1/BnyBj0T65WIGOdR6W7EtsUY30NJw1cw58hWq/sIvLJVRyKSmxQzG34cdbANbwMGYP+FPZ09KeiNrR7jPExt+FhewfuGXhRaculGLBZEM0fXir9xOU1JTYZ6QAXB+cNXKOAPI2dpLRdlHCb7cCnRqwVmaohKp6BB2XGQcAvSluuDFyjAByJiOJnFZXdxN2kxI4AliIfUNo4mgYxcI0CMny2SaVn0hJgrRKfBHyODCMx0GgbAdyL3AclMfBpAceSGzFASok2W0w1pkyYiP7caifgNuRp8BrgZ2BnYJhlW7m/A49KK+XTKHSin91x6QBOAp4NaO9GyPQ/JT5Ghg1PYuCZ9wyTAuXjNn0H/Fml7T8HHI9eZqLwDJIZThq4RoHyem2OJVspLyDlaEmMddYB5wInI3NwmDhh4BqtlD/qqEWP+B+QmWZuAU4DjgH2Qr6U8vgS6bz2PPIH14QAxzzDpBUpT/7H5TvWcH+flH6uQTLT29dfwDcR1ndaDBBBfuL/Z+quyMyV62u8742EjxfixzkD1yhQfma2EO3qp544aeAaBeSy0iTqNEH1wFkD1yig3wSeUu8DCcCZO/CoFJDJs8wXSHsgXfXTxHkD1yggd+YvKm031PlY/OT6EXoleO9D7lbajiUdc28YA9fwBFkOfK20x7m7rgYNZeAa/k4O2gupYcjddT1oOAPX8AuyDH0my3nIAFy1pCENXMPsKDclYLn7gQtrtP+lNKiBa5iC/EiwKAuQN3pav6skDEc60Gnv86EBDFxD6/2+FP1TApAZj9ciQ2gkpTdwIzK37L4ByzRUmfLTbdA4tVPiSuRmcZzSti3SrWcqMp7t70R7EDkcuBiZ/lqb7sfjDJQRnxuFlrHXW1+fzyZ4YnY/3yLvMtaVfjYiT5IHIK+IRyKTYNn4BXkhtSLC/pwl7GXUA0hHhAew/0EHUt6LJA7LgXOADRVswwmifGP4FlLrb6LyTtMm65EPeSbQFAOI95361cAQYD7lU4bGpR2Z0H0I1fuQxwnCPCSIXsinC8dTmpg9wjprkWm0lyHvzZsoJO3Q8CvyEc9CJMv2AvZGrrp6AV1IeetEZkVuR8y+SQgtXV1daR9DEx9pzx/SxKApSMb4F+Gistxuh6KlAAAAAElFTkSuQmCC"},"5cfe":function(e,t,n){},"60d4":function(e,t,n){"use strict";var s=n("36c6"),a=n.n(s);a.a},6417:function(e,t,n){"use strict";var s=n("2593"),a=n.n(s);a.a},"692d":function(e,t,n){},"7d91":function(e,t,n){"use strict";var s=n("5cfe"),a=n.n(s);a.a},8076:function(e,t,n){},8361:function(e,t,n){"use strict";var s=n("692d"),a=n.n(s);a.a},8793:function(e,t,n){},"8a60":function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"chat-mensaje"},[n("div",{staticClass:"chat-mensaje-imagen"},[n("label",{directives:[{name:"show",rawName:"v-show",value:null!=e.sender,expression:"sender != null"}],staticClass:"chat-mensaje-sender"},[e._v(e._s(e.sender))]),n("label",[e._v(e._s(e.mensaje.message.original_file))]),n("label",{staticClass:"chat-mensaje-hora"},[e._v(e._s(e.getHora()))]),n("img",{attrs:{src:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file}}),n("a",{attrs:{href:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,download:""}},[e._v("Descargar")])])])},a=[],o=(n("ac1f"),n("1276"),{name:"MensajeImagen",components:{},data:function(){return{mostrarImagen:!1}},props:{mensaje:[Object],sender:[String]},computed:{},mounted:function(){},created:function(){},methods:{getHora:function(){var e=this.mensaje.created_at.split("T")[1].split(":");return e[0]+":"+e[1]}}}),r=o,i=(n("7d91"),n("2877")),c=Object(i["a"])(r,s,a,!1,null,"72d94e22",null);t["a"]=c.exports},"901b":function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"chat-mensaje"},[n("div",{staticClass:"chat-mensaje-archivo"},[n("label",{directives:[{name:"show",rawName:"v-show",value:null!=e.sender,expression:"sender != null"}],staticClass:"chat-mensaje-sender"},[e._v(e._s(e.sender))]),n("label",{staticClass:"chat-mensaje-archivo-titulo"},[e._v(e._s(e.mensaje.message.original_file))]),n("label",{staticClass:"chat-mensaje-hora"},[e._v(e._s(e.getHora()))]),n("a",{attrs:{href:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,download:""}},[e._v("Descargar")])])])},a=[],o=(n("ac1f"),n("1276"),{name:"MensajeArchivo",components:{},data:function(){return{}},props:{mensaje:[Object],sender:[String]},computed:{},mounted:function(){},created:function(){},methods:{getHora:function(){var e=this.mensaje.created_at.split("T")[1].split(":");return e[0]+":"+e[1]}}}),r=o,i=(n("33d2"),n("2877")),c=Object(i["a"])(r,s,a,!1,null,"4e0af4a6",null);t["a"]=c.exports},"97b4":function(e,t,n){"use strict";var s=n("3f75"),a=n.n(s);a.a},ab56:function(e,t,n){},b148:function(e,t,n){},b1af:function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"chat-mensaje"},[n("label",{staticClass:"chat-mensaje-hora"},[e._v(e._s(e.getHora()))]),n("div",{staticClass:"chat-mensaje-video"},[n("label",{directives:[{name:"show",rawName:"v-show",value:null!=e.sender,expression:"sender != null"}],staticClass:"chat-mensaje-sender"},[e._v(e._s(e.sender))]),n("label",[e._v(e._s(e.mensaje.message.original_file))]),n("video",{attrs:{controls:"",name:"media"}},[n("source",{attrs:{src:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,type:"video/mp4"}})]),n("a",{attrs:{href:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,download:""}},[e._v("Descargar")])])])},a=[],o=(n("ac1f"),n("1276"),{name:"MensajeVideo",components:{},data:function(){return{}},props:{mensaje:[Object],sender:[String]},computed:{},mounted:function(){},created:function(){},methods:{getHora:function(){var e=this.mensaje.created_at.split("T")[1].split(":");return e[0]+":"+e[1]}}}),r=o,i=(n("6417"),n("2877")),c=Object(i["a"])(r,s,a,!1,null,"f8668422",null);t["a"]=c.exports},b620:function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"chat-mensaje chat-mensaje-texto"},[n("label",{directives:[{name:"show",rawName:"v-show",value:null!=e.sender,expression:"sender != null"}],staticClass:"chat-mensaje-sender"},[e._v(e._s(e.sender))]),n("label",[e._v(e._s(e.mensaje.message.text))]),n("label",{staticClass:"chat-mensaje-hora"},[e._v(e._s(e.getHora()))])])},a=[],o=(n("ac1f"),n("1276"),{name:"MensajeTexto",components:{},data:function(){return{}},props:{mensaje:[Object],sender:[String]},computed:{},mounted:function(){},created:function(){},methods:{getHora:function(){var e=this.mensaje.created_at.split("T")[1].split(":");return e[0]+":"+e[1]}}}),r=o,i=(n("97b4"),n("2877")),c=Object(i["a"])(r,s,a,!1,null,"31b155be",null);t["a"]=c.exports},b78c:function(e,t,n){"use strict";var s=n("8793"),a=n.n(s);a.a},d981:function(e,t,n){"use strict";var s=n("30f4"),a=n.n(s);a.a},e1ab:function(e,t,n){"use strict";var s=n("2ce7"),a=n.n(s);a.a},f826:function(e,t,n){},f8f5:function(e,t,n){},ff3b:function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"chat-mensaje"},[n("div",{staticClass:"chat-mensaje-audio"},[n("label",{directives:[{name:"show",rawName:"v-show",value:null!=e.sender,expression:"sender != null"}],staticClass:"chat-mensaje-sender"},[e._v(e._s(e.sender))]),n("label",{staticClass:"chat-mensaje-audio-titulo"},[e._v(e._s(e.mensaje.message.original_file))]),n("label",{staticClass:"chat-mensaje-hora"},[e._v(e._s(e.getHora()))]),n("audio",{attrs:{controls:"",name:"media"}},[n("source",{attrs:{src:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,type:"audio/mpeg"}})]),n("a",{attrs:{href:"http://10.120.17.157:8081/storage/"+e.mensaje.message.file,download:""}},[e._v("Descargar")])])])},a=[],o=(n("ac1f"),n("1276"),{name:"MensajeAudio",components:{},data:function(){return{}},props:{mensaje:[Object],sender:[String]},computed:{},mounted:function(){},created:function(){},methods:{getHora:function(){var e=this.mensaje.created_at.split("T")[1].split(":");return e[0]+":"+e[1]}}}),r=o,i=(n("3a79"),n("2877")),c=Object(i["a"])(r,s,a,!1,null,"7b5dfac8",null);t["a"]=c.exports}});
//# sourceMappingURL=app.d692dffc.js.map