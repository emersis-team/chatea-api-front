(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-babda4c6"],{"3dc5":function(t,a,o){},6135:function(t,a,o){"use strict";o.r(a);var e=function(){var t=this,a=t._self._c;return a("div",{staticClass:"admin"},[a("RouterLink",{attrs:{to:"/"}},[a("img",{staticClass:"back",attrs:{src:o("427d")}})]),a("h2",[t._v("Administracion de Usuarios")]),a("form",{staticClass:"search-container",on:{submit:t.search}},[a("div",{staticClass:"user"},[a("label",{attrs:{for:""}},[t._v("Organizacion")]),a("v-select",{attrs:{options:t.organizaciones,label:"name",placeholder:"Todas"},model:{value:t.orgSelected,callback:function(a){t.orgSelected=a},expression:"orgSelected"}})],1),a("button",{staticClass:"modify",attrs:{type:"submit",disabled:null==t.orgSelected}},[t._v(" Buscar ")])]),a("table",[t._m(0),t._l(t.contactos,(function(o,e){return a("tr",{key:e},[a("td",[a("RouterLink",{attrs:{to:`/admin/${o.email}/${o.id}`}},[t._v(" "+t._s(o.name)+" - "+t._s(o.email)+" ")])],1),a("td",[a("RouterLink",{attrs:{to:"/admin/"+(o.organization?o.organization:"alguna organizacion")}},[t._v(" "+t._s(o.organization?o.organization:"alguna organizacion")+" ")])],1),a("td",{staticClass:"numeros"},[t._v("3")]),a("td",{staticClass:"numeros"},[t._v("1/1/2020")])])}))],2)],1)},n=[function(){var t=this,a=t._self._c;return a("tr",[a("th",[t._v("Nombre")]),a("th",[t._v("Organizacion")]),a("th",[t._v("N° de contactos")]),a("th",[t._v("Fecha de creacion")])])}],s=o("4a7a"),c=o.n(s),i=(o("6dfc"),{name:"admin",components:{vSelect:c.a},data(){return{contactos:[],selected:null,orgSelected:null,organizaciones:[]}},computed:{},created(){},mounted(){this.getContactos(),this.getOrganizaciones()},methods:{search(t){t.preventDefault(),this.orgSelected!={}&&null!=this.orgSelected&&console.log("orgSelected: ",this.orgSelected)},getContactos(){var t=this;this.$axios.get(this.$localurl+"/usuarios",{headers:{Authorization:localStorage.getItem("$token")}}).then((function(a){t.contactos=a.data,console.log("contactos: ",t.contactos)})).catch((function(t){console.log("error",t)}))},getOrganizaciones(){var t=this;const a=`?id=${localStorage.getItem("$userId")}&name=${localStorage.getItem("$username")}`;this.$axios.get(this.$localurl+"/locations"+a,{headers:{Authorization:localStorage.getItem("$token")}}).then((function(a){t.organizaciones=a.data,console.log("organizaciones: ",t.organizaciones)})).catch((function(t){console.log("error",t)}))}}}),r=i,l=(o("ddc5"),o("2877")),d=Object(l["a"])(r,e,n,!1,null,null,null);a["default"]=d.exports},ddc5:function(t,a,o){"use strict";o("3dc5")}}]);
//# sourceMappingURL=chunk-babda4c6.29c635c8.js.map