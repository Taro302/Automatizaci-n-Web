@falloCategoria
Feature: Product - Store
Scenario: Fallo al ingresar una categoría inexistente
  Given estoy en la página de la tienda
  And ingreso a iniciar sesion
  And me logueo con mi usuario "taiperojasjavier@gmail.com" y clave "@eiou123aeiou"
  When navego a la categoría "Autos"
  Then espero que la automatización falle, ya que la categoría no existe