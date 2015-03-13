#HOWTO Run this shit

# Fail Proof #

  1. Crear un datasource en $JBOSS\_HOME/deploy
  1. Ponerle un nombre decente al datasource
  1. Referenciar el nombre del datasource desde el persistence.xml
  1. Correr y ver que pasa.

## Pincha al intentar crear la base? ##
  * Revisa las clases, probablemente te falten clases para conectarte a la base de datos en $JBOSS\_HOME/lib
  * Revisa que tengas la base de datos creadas y con un usuario asociado (root a veces trae problemas). De no tenerlas, volve al persistence.xml y toca la politica para que sea "create". De esta manera deberia crearte todas las tablas.

## Sigue Pinchando? ##
Tu entorno esta jodido.