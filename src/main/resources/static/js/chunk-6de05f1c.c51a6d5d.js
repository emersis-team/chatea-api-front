(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6de05f1c"],{"2c44":function(t,e,i){},"46bb":function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t._self._c;return e("form",{staticClass:"admin",on:{submit:t.asign}},[e("loading",{attrs:{active:t.isLoading,"can-cancel":!1,"is-full-page":t.fullPage},on:{"update:active":function(e){t.isLoading=e}}}),e("RouterLink",{attrs:{to:"/admin-users"}},[e("img",{staticClass:"back",attrs:{src:i("427d")}})]),e("h2",[t._v("Actualizar Usuario "+t._s(t.selected))]),e("div",{staticClass:"selection"},[e("div",{staticClass:"options"},[e("label",{attrs:{for:""}},[t._v("Organizacion")]),e("v-select",{attrs:{placeholder:"Seleccione organizacion del contacto",options:t.organizaciones,label:"name"},model:{value:t.organizacionSeleccionada,callback:function(e){t.organizacionSeleccionada=e},expression:"organizacionSeleccionada"}})],1),e("div",{staticClass:"options"},[e("label",{attrs:{for:""}},[t._v("Contactos")]),""!=t.selected?e("v-select",{attrs:{multiple:"",options:t.contactosRecortados,label:"formattedName"},model:{value:t.contactosSeleccionados,callback:function(e){t.contactosSeleccionados=e},expression:"contactosSeleccionados"}}):t._e()],1),e("div",{staticClass:"options"},[e("label",{attrs:{for:""}},[t._v("Grupos")]),""!=t.selected?e("v-select",{attrs:{multiple:"",options:t.gruposRecortados,label:"name"},model:{value:t.gruposSeleccionados,callback:function(e){t.gruposSeleccionados=e},expression:"gruposSeleccionados"}}):t._e()],1)]),""!=t.selected&&null!=t.selected&&(t.contactosSeleccionados!=[]&&null!=t.contactosSeleccionados||t.gruposSeleccionados!=[]&&null!=t.gruposSeleccionados)?e("button",{staticClass:"asign",attrs:{disabled:0==t.contactosSeleccionados.length&&0==t.gruposSeleccionados.length}},[t._v(" Asignar ")]):t._e()],1)},o=[],a=i("9062"),s=i.n(a),r=(i("e40d"),i("4a7a")),c=i.n(r),l=(i("6dfc"),{name:"updateUser",components:{Loading:s.a,vSelect:c.a},data(){return{selected:this.$route.params.user,id:this.$route.params.id,organizaciones:[],organizacionSeleccionada:"",contactos:[],contactosRec:[],contactosSeleccionados:[],gruposSeleccionados:[],grupos:[],lugar:"",isLoading:!1,fullPage:!0}},computed:{contactosRecortados(){const t=[...this.contactos];if(""!=this.selected){this.contactos.findIndex(({email:t})=>t===this.selected)}return t.map(t=>({...t,formattedName:"null"!==t.name?t.name+" - ":""+t.email!=="null"?t.email:""}))},gruposRecortados(){const t=[...this.grupos];return""!=this.selected&&this.contactos.splice(this.grupos.indexOf(this.selected),1),t}},created(){},mounted(){this.getContactos(),this.getOrganizaciones(),this.getGrupos(),this.initUserInfo()},methods:{initUserInfo(){var t=this;this.$axios.get(this.$localurl+"/conversations/"+this.id).then(e=>{console.log(e);t.hasConversations=!0,t.contactosSeleccionados=e.data.conversations.filter(t=>!isGroup(t)),t.gruposSeleccionados=e.data.conversations.filter(t=>isGroup(t))}).catch(e=>{t.hasConversations=!1,null==e||401!=e.status&&400!=e.status||(localStorage.removeItem("$expire"),"login"!=window.location.pathname.split("/").reverse()[0]&&t.$router.push("/login"))})},asign(t){let e,i;t.preventDefault(),null!=this.contactosSeleccionados&&(e=this.contactosSeleccionados.map(({id:t})=>t)),null!=this.gruposSeleccionados&&(i=this.gruposSeleccionados.map(({id:t})=>t)),this.isLoading=!0;var n=this;const o={contacts:e,groups:i};this.$axios.put(this.$localurl+"/nuevosContactos/"+this.id,o).then((function(t){n.isLoading=!1,console.log("response: ",t.data)})).catch((function(t){n.isLoading=!1,console.log("error",t)}))},getGrupos(){var t=this;this.$axios.get(this.$localurl+"/groups",{headers:{Authorization:localStorage.getItem("$token")}}).then((function(e){t.grupos=e.data})).catch((function(t){console.log("error",t)}))},getContactos(){var t=this;this.$axios.get(this.$localurl+"/usuarios",{headers:{Authorization:localStorage.getItem("$token")}}).then((function(e){t.contactos=e.data})).catch((function(t){console.log("error",t)}))},getOrganizaciones(){var t=this;this.$axios.get(this.$localurl+"/locations",{headers:{Authorization:localStorage.getItem("$token")}}).then((function(e){t.organizaciones=e.data})).catch((function(t){console.log("error",t)}))}}}),u=l,d=(i("4db3"),i("2877")),h=Object(d["a"])(u,n,o,!1,null,null,null);e["default"]=h.exports},"4db3":function(t,e,i){"use strict";i("2c44")},9062:function(t,e,i){!function(e,i){t.exports=i()}("undefined"!=typeof self&&self,(function(){return function(t){var e={};function i(n){if(e[n])return e[n].exports;var o=e[n]={i:n,l:!1,exports:{}};return t[n].call(o.exports,o,o.exports,i),o.l=!0,o.exports}return i.m=t,i.c=e,i.d=function(t,e,n){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},i.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var o in t)i.d(n,o,function(e){return t[e]}.bind(null,o));return n},i.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="",i(i.s=1)}([function(t,e,i){},function(t,e,i){"use strict";i.r(e);var n="undefined"!=typeof window?window.HTMLElement:Object,o={mounted:function(){this.enforceFocus&&document.addEventListener("focusin",this.focusIn)},methods:{focusIn:function(t){if(this.isActive&&t.target!==this.$el&&!this.$el.contains(t.target)){var e=this.container?this.container:this.isFullPage?null:this.$el.parentElement;(this.isFullPage||e&&e.contains(t.target))&&(t.preventDefault(),this.$el.focus())}}},beforeDestroy:function(){document.removeEventListener("focusin",this.focusIn)}};function a(t,e,i,n,o,a,s,r){var c,l="function"==typeof t?t.options:t;if(e&&(l.render=e,l.staticRenderFns=i,l._compiled=!0),n&&(l.functional=!0),a&&(l._scopeId="data-v-"+a),s?(c=function(t){(t=t||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext)||"undefined"==typeof __VUE_SSR_CONTEXT__||(t=__VUE_SSR_CONTEXT__),o&&o.call(this,t),t&&t._registeredComponents&&t._registeredComponents.add(s)},l._ssrRegister=c):o&&(c=r?function(){o.call(this,(l.functional?this.parent:this).$root.$options.shadowRoot)}:o),c)if(l.functional){l._injectStyles=c;var u=l.render;l.render=function(t,e){return c.call(e),u(t,e)}}else{var d=l.beforeCreate;l.beforeCreate=d?[].concat(d,c):[c]}return{exports:t,options:l}}var s=a({name:"spinner",props:{color:{type:String,default:"#000"},height:{type:Number,default:64},width:{type:Number,default:64}}},(function(){var t=this.$createElement,e=this._self._c||t;return e("svg",{attrs:{viewBox:"0 0 38 38",xmlns:"http://www.w3.org/2000/svg",width:this.width,height:this.height,stroke:this.color}},[e("g",{attrs:{fill:"none","fill-rule":"evenodd"}},[e("g",{attrs:{transform:"translate(1 1)","stroke-width":"2"}},[e("circle",{attrs:{"stroke-opacity":".25",cx:"18",cy:"18",r:"18"}}),e("path",{attrs:{d:"M36 18c0-9.94-8.06-18-18-18"}},[e("animateTransform",{attrs:{attributeName:"transform",type:"rotate",from:"0 18 18",to:"360 18 18",dur:"0.8s",repeatCount:"indefinite"}})],1)])])])}),[],!1,null,null,null).exports,r=a({name:"dots",props:{color:{type:String,default:"#000"},height:{type:Number,default:240},width:{type:Number,default:60}}},(function(){var t=this.$createElement,e=this._self._c||t;return e("svg",{attrs:{viewBox:"0 0 120 30",xmlns:"http://www.w3.org/2000/svg",fill:this.color,width:this.width,height:this.height}},[e("circle",{attrs:{cx:"15",cy:"15",r:"15"}},[e("animate",{attrs:{attributeName:"r",from:"15",to:"15",begin:"0s",dur:"0.8s",values:"15;9;15",calcMode:"linear",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"fill-opacity",from:"1",to:"1",begin:"0s",dur:"0.8s",values:"1;.5;1",calcMode:"linear",repeatCount:"indefinite"}})]),e("circle",{attrs:{cx:"60",cy:"15",r:"9","fill-opacity":"0.3"}},[e("animate",{attrs:{attributeName:"r",from:"9",to:"9",begin:"0s",dur:"0.8s",values:"9;15;9",calcMode:"linear",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"fill-opacity",from:"0.5",to:"0.5",begin:"0s",dur:"0.8s",values:".5;1;.5",calcMode:"linear",repeatCount:"indefinite"}})]),e("circle",{attrs:{cx:"105",cy:"15",r:"15"}},[e("animate",{attrs:{attributeName:"r",from:"15",to:"15",begin:"0s",dur:"0.8s",values:"15;9;15",calcMode:"linear",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"fill-opacity",from:"1",to:"1",begin:"0s",dur:"0.8s",values:"1;.5;1",calcMode:"linear",repeatCount:"indefinite"}})])])}),[],!1,null,null,null).exports,c=a({name:"bars",props:{color:{type:String,default:"#000"},height:{type:Number,default:40},width:{type:Number,default:40}}},(function(){var t=this.$createElement,e=this._self._c||t;return e("svg",{attrs:{xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 30 30",height:this.height,width:this.width,fill:this.color}},[e("rect",{attrs:{x:"0",y:"13",width:"4",height:"5"}},[e("animate",{attrs:{attributeName:"height",attributeType:"XML",values:"5;21;5",begin:"0s",dur:"0.6s",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"y",attributeType:"XML",values:"13; 5; 13",begin:"0s",dur:"0.6s",repeatCount:"indefinite"}})]),e("rect",{attrs:{x:"10",y:"13",width:"4",height:"5"}},[e("animate",{attrs:{attributeName:"height",attributeType:"XML",values:"5;21;5",begin:"0.15s",dur:"0.6s",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"y",attributeType:"XML",values:"13; 5; 13",begin:"0.15s",dur:"0.6s",repeatCount:"indefinite"}})]),e("rect",{attrs:{x:"20",y:"13",width:"4",height:"5"}},[e("animate",{attrs:{attributeName:"height",attributeType:"XML",values:"5;21;5",begin:"0.3s",dur:"0.6s",repeatCount:"indefinite"}}),e("animate",{attrs:{attributeName:"y",attributeType:"XML",values:"13; 5; 13",begin:"0.3s",dur:"0.6s",repeatCount:"indefinite"}})])])}),[],!1,null,null,null).exports,l=a({name:"vue-loading",mixins:[o],props:{active:Boolean,programmatic:Boolean,container:[Object,Function,n],isFullPage:{type:Boolean,default:!0},enforceFocus:{type:Boolean,default:!0},lockScroll:{type:Boolean,default:!1},transition:{type:String,default:"fade"},canCancel:Boolean,onCancel:{type:Function,default:function(){}},color:String,backgroundColor:String,blur:{type:String,default:"2px"},opacity:Number,width:Number,height:Number,zIndex:Number,loader:{type:String,default:"spinner"}},data:function(){return{isActive:this.active}},components:{Spinner:s,Dots:r,Bars:c},beforeMount:function(){this.programmatic&&(this.container?(this.isFullPage=!1,this.container.appendChild(this.$el)):document.body.appendChild(this.$el))},mounted:function(){this.programmatic&&(this.isActive=!0),document.addEventListener("keyup",this.keyPress)},methods:{cancel:function(){this.canCancel&&this.isActive&&(this.hide(),this.onCancel.apply(null,arguments))},hide:function(){var t=this;this.$emit("hide"),this.$emit("update:active",!1),this.programmatic&&(this.isActive=!1,setTimeout((function(){var e;t.$destroy(),void 0!==(e=t.$el).remove?e.remove():e.parentNode.removeChild(e)}),150))},disableScroll:function(){this.isFullPage&&this.lockScroll&&document.body.classList.add("vld-shown")},enableScroll:function(){this.isFullPage&&this.lockScroll&&document.body.classList.remove("vld-shown")},keyPress:function(t){27===t.keyCode&&this.cancel()}},watch:{active:function(t){this.isActive=t},isActive:function(t){t?this.disableScroll():this.enableScroll()}},computed:{bgStyle:function(){return{background:this.backgroundColor,opacity:this.opacity,backdropFilter:"blur(".concat(this.blur,")")}}},beforeDestroy:function(){document.removeEventListener("keyup",this.keyPress)}},(function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("transition",{attrs:{name:t.transition}},[i("div",{directives:[{name:"show",rawName:"v-show",value:t.isActive,expression:"isActive"}],staticClass:"vld-overlay is-active",class:{"is-full-page":t.isFullPage},style:{zIndex:t.zIndex},attrs:{tabindex:"0","aria-busy":t.isActive,"aria-label":"Loading"}},[i("div",{staticClass:"vld-background",style:t.bgStyle,on:{click:function(e){return e.preventDefault(),t.cancel(e)}}}),i("div",{staticClass:"vld-icon"},[t._t("before"),t._t("default",[i(t.loader,{tag:"component",attrs:{color:t.color,width:t.width,height:t.height}})]),t._t("after")],2)])])}),[],!1,null,null,null).exports,u=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},i=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{};return{show:function(){var n=arguments.length>0&&void 0!==arguments[0]?arguments[0]:e,o=arguments.length>1&&void 0!==arguments[1]?arguments[1]:i,a={programmatic:!0},s=Object.assign({},e,n,a),r=new(t.extend(l))({el:document.createElement("div"),propsData:s}),c=Object.assign({},i,o);return Object.keys(c).map((function(t){r.$slots[t]=c[t]})),r}}};i(0),l.install=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},i=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{},n=u(t,e,i);t.$loading=n,t.prototype.$loading=n},e.default=l}]).default}))},e40d:function(t,e,i){}}]);
//# sourceMappingURL=chunk-6de05f1c.c51a6d5d.js.map