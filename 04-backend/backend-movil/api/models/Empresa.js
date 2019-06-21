/**
 * Empresa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
    },
    
    // CONFIGURACION DEL PAPA - RELACION
    serviciosDeEmpresa: {       // nombre atributo de la relacion
      collection: 'servicio',   // nombre del modelo a relacionar
      via: 'fkEmpresa'          // nombre atributo FK del otro modelo

    }

  },

};

