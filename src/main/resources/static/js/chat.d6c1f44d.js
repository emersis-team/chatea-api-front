(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chat"],{"03a8":function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAqCAYAAAD1T9h6AAAABHNCSVQICAgIfAhkiAAAAVlJREFUWEfV2c1Nw0AQQOGXAhCUkBLoAOgESsiFHuggR1JBOHIDUQEUgEQJHDhyiCayI8da/86sd8b3jN+3q0ReZ4XtdQXsgQ3waTs6PW1leBOJfwOugV/gbgmEFaAZX6/JIggLQCpeEF/AbbUbhht9PkoLKBovFA2geLwG4CJ+LsBN/ByAq/ipAHfxUwAu48cC3MaPAbiOHwK4j+8DhIjvAoSJTwFCxbcB4eKbgJDxNaAr/q86Uf1ne5jXD97K4/Q7cKOfVWTCowDkDCuIyyIJupseAXJFRZwANeIDuGgtyhPwqluobJ/+bh8pu3biAXjOlqEYnDoTh0J0HerDIPreSoRADL1WcY8YAvT9xLr4Yo8BuEaMBbhFTAG4REwFuEPMAbhCzAW4QWgALhBaQHGEBaAPIX/0yWEp22UFSCF2wH228mqwJaCJeFkiXm5oDZCZa+An98rX8w+YCmb+NJKbQwAAAABJRU5ErkJggg=="},"27ef":function(e,t,s){},"293a":function(e,t,s){"use strict";s.r(t);var a=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"home"},[a("div",{staticClass:"home-body"},[a("div",{staticClass:"home-right"},[a("div",{staticClass:"chat"},[a("div",{staticClass:"chat-top"},[a("img",{attrs:{src:s("03a8")},on:{click:function(t){return e.$router.back()}}}),a("p",{on:{click:function(t){return e.$router.back()}}},[e._v(" "+e._s(null!=e.$conversacionElegida?e.$conversacionElegida.user_dest.name:"")+" ")])]),a("div",{ref:"chatScroll",staticClass:"chat-scroll",attrs:{id:"chatScroll"},on:{scroll:e.onScroll}},e._l(e.mensajes,(function(t){return a("div",{key:t.id,staticClass:"chat-container",class:{"chat-mensaje-propio":t.sender_id==e.userId},attrs:{id:t.id}},[null!=t.fecha?a("div",{staticClass:"chat-separador"},[a("label",[e._v(e._s(t.fecha))])]):e._e(),null==t.fecha?a("div",[t.sender_id!=e.userId?a("span",{staticClass:"chat-tail"},[a("svg",{staticStyle:{display:"block"},attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 8 13",width:"8",height:"13"}},[a("path",{attrs:{opacity:".13",fill:"#0000000",d:"M1.533 3.568L8 12.193V1H2.812C1.042 1 .474 2.156 1.533 3.568z"}}),a("path",{attrs:{fill:"currentColor",d:"M1.533 2.568L8 11.193V0H2.812C1.042 0 .474 1.156 1.533 2.568z"}})])]):e._e(),t.sender_id==e.userId?a("span",{staticClass:"chat-tail-out"},[a("svg",{staticClass:"chat-tail-svg",staticStyle:{display:"block"},attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 8 13",width:"8",height:"13"}},[a("path",{attrs:{opacity:".13",d:"M5.188 1H0v11.193l6.467-8.625C7.526 2.156 6.958 1 5.188 1z"}}),a("path",{attrs:{fill:"currentColor",d:"M5.188 0H0v11.193l6.467-8.625C7.526 1.156 6.958 0 5.188 0z"}})])]):e._e(),null!=t.message_type&&"TextMessage"==t.message_type.substr(11,100)?a("MensajeTexto",{attrs:{mensaje:t}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esArchivo(t)?a("MensajeArchivo",{attrs:{mensaje:t}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esImagen(t)?a("MensajeImagen",{attrs:{mensaje:t}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esVideo(t)?a("MensajeVideo",{attrs:{mensaje:t}}):e._e(),null!=t.message_type&&"FileMessage"==t.message_type.substr(11,100)&&e.esAudio(t)?a("MensajeAudio",{attrs:{mensaje:t}}):e._e()],1):e._e()])})),0),a("div",{staticClass:"chat-bottom"},[a("div",{staticClass:"chat-adjuntar",attrs:{title:"Adjuntar"},on:{click:function(t){return e.adjuntar()}}},[a("input",{ref:"adjuntoFiles",staticClass:"app-hide",attrs:{type:"file",multiple:""},on:{change:function(t){return e.changeAdjunto()}}}),a("img",{attrs:{src:s("57bf")}})]),a("input",{ref:"inputTexto",attrs:{type:"text",placeholder:"Escribe un mensaje aquí",maxlength:"140"},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.enviar()}}}),a("img",{staticClass:"chat-enviar",attrs:{src:s("4556")},on:{click:function(t){return e.enviar()}}})])])])])])},n=[],i=(s("99af"),s("4de4"),s("4160"),s("caad"),s("45fc"),s("a434"),s("ac1f"),s("1276"),s("159b"),s("b620")),r=s("901b"),o=s("8a60"),l=s("b1af"),c=s("ff3b"),u={name:"Chat",components:{MensajeTexto:i["a"],MensajeArchivo:r["a"],MensajeImagen:o["a"],MensajeVideo:l["a"],MensajeAudio:c["a"]},data:function(){return{mensajes:[],userId:null,primeraPagina:!0,currentPage:0,lastPage:0,mensajeOffset:null,actualizarTimer:null}},props:{},computed:{},mounted:function(){this.userId=localStorage.getItem("$userId"),this.getChat(null,!0),this.actualizar(),this.mensajes=[],this.$refs.chatScroll.addEventListener("touchmove",this.onScroll)},created:function(){var e=this;this.$eventHub.$on("chat-get",(function(t){return e.getChat(t,!0)}))},methods:{actualizar:function(){var e=this;clearTimeout(this.actualizarTimer),this.actualizarTimer=setTimeout((function(){e.getChat(null,!1),e.actualizar()}),3e3)},esImagen:function(e){var t=e.message.files[0].file.split(".")[e.message.files[0].file.split(".").length-1].toLowerCase();return"png"==t||"jpg"==t||"svg"==t||"jpeg"==t},esVideo:function(e){var t=e.message.files[0].file.split(".")[e.message.files[0].file.split(".").length-1].toLowerCase();return"webm"==t||"mkv"==t||"flv"==t||"mp4"==t||"mov"==t||"avi"==t},esAudio:function(e){var t=e.message.files[0].file.split(".")[e.message.files[0].file.split(".").length-1].toLowerCase();return"m4a"==t||"qt"==t||"4mb"==t},esArchivo:function(e){return 0==this.esImagen(e)&&0==this.esVideo(e)&&0==this.esAudio(e)},getChat:function(e,t){if(null==e?e=this.$route.params.id:(this.mensajes=[],this.primeraPagina=!0),null!=e){var s=this;this.$axios.get(this.$localurl+"/api/v1/messages/"+e).then((function(e){1!=s.primeraPagina||s.isOverflown(document.getElementById("chatScroll"))||(s.primeraPagina=!1,s.getChatPage(2));var a=!1;s.lastPage=e.data.messages.last_page,e.data.messages.data.reverse(),e.data.messages.data.forEach((function(e){s.mensajes.some((function(t){return t.id==e.id}))||e.conversation_id!=s.$route.params.id||(s.mensajes.push(e),a=!0)})),1==a&&(s.mensajeOffset=s.mensajes[s.mensajes.length-1]),s.getSeparadores(t)})).catch((function(e){clearTimeout(s.actualizarTimer),null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login"))}))}},getChatPage:function(e){this.mensajeOffset=this.mensajes[0],null!=this.mensajeOffset&&null==this.mensajeOffset.id&&(this.mensajeOffset=this.mensajes[1]),this.currentPage=e;var t="";null!=e&&(t="?page="+e);var s=this;this.$axios.get(this.$localurl+"/api/v1/messages/"+this.$route.params.id+t).then((function(e){e.data.messages.data.reverse(),s.mensajes=e.data.messages.data.concat(s.mensajes),s.getSeparadores(!0)})).catch((function(e){null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login"))}))},getSeparadores:function(e){var t=this,s=[];this.mensajes=this.mensajes.filter((function(e){return null==e.fecha}));for(var a=this.mensajes.length,n=0;n<a;n++){var i,r,o,l=this.mensajes[n];if(null!=l.created_at)(function(){i=new Date(l.created_at),i.setHours(i.getHours()+3);var e=i.getDate(),c=i.getMonth()+1,u=i.getFullYear(),h=e+"/"+c+"/"+u;r=new Date;var g=r.getDate(),m=r.getMonth()+1,f=r.getFullYear();e!=g||c!=m||u!=f?0==s.includes(h)&&(o=["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"],h=o[i.getDay()]+" "+h,t.mensajes.some((function(e){return e.fecha==h}))||(t.mensajes.splice(n,0,{fecha:h}),a++)):t.mensajes.some((function(e){return"HOY"==e.fecha}))||(t.mensajes.splice(n,0,{fecha:"HOY"}),a++)})()}if(1==e){var c=this;this.$nextTick((function(){c.scrollToBottom()}))}},onScroll:function(){var e=this.$refs.chatScroll;e.scrollTop<.1*e.clientHeight&&this.currentPage<this.lastPage&&(this.offset=this.offset+this.limit,this.currentPage++,this.getChatPage(this.currentPage))},scrollToBottom:function(){var e=this;this.$nextTick((function(){null!=e.mensajeOffset&&(null!=document.getElementById(e.mensajeOffset.id)?document.getElementById("chatScroll").scrollTop=document.getElementById(e.mensajeOffset.id).offsetTop:setTimeout((function(){e.scrollToBottom()}),200))}))},enviar:function(){this.scrollToBottom();var e=this.$refs.inputTexto.value;if(""!=e){this.$refs.inputTexto.value="";var t=new FormData;t.append("message",e),t.append("receiver_id",this.$route.params.user_dest_id);var s=this;this.$axios.post(this.$localurl+"/api/v1/messages/textMessage",t).then((function(){s.getChat(null,!0)})).catch((function(e){null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&s.$router.push("/login")),alert("Se produjo un error, reintente")}))}},isOverflown:function(e){return e.scrollHeight>e.clientHeight||e.scrollWidth>e.clientWidth},adjuntar:function(){this.$refs.adjuntoFiles.click()},changeAdjunto:function(){if(this.$refs.adjuntoFiles.files.length>0){var e=new FormData;e.append("message","archivos"),e.append("receiver_id",this.$route.params.user_dest_id),this.$refs.adjuntoFiles.files.forEach((function(t,s){e.append("file["+s+"]",t)}));var t=this;this.$axios.post(this.$localurl+"/api/v1/messages/fileMessage",e).then((function(){t.getChat(null,!0)})).catch((function(e){null!=e&&null!=e.response&&401==e.response.status&&(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&t.$router.push("/login")),alert("Se produjo un error, reintente")}))}}}},h=u,g=(s("43a1"),s("7732"),s("2877")),m=Object(g["a"])(h,a,n,!1,null,"e2025b62",null);t["default"]=m.exports},"43a1":function(e,t,s){"use strict";var a=s("bf68"),n=s.n(a);n.a},7732:function(e,t,s){"use strict";var a=s("27ef"),n=s.n(a);n.a},bf68:function(e,t,s){}}]);
//# sourceMappingURL=chat.d6c1f44d.js.map