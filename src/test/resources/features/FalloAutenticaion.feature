@falloAutenticacion
Feature: Product - Store
Scenario: Fallo de autenticación con usuario y clave inválidos
  Given estoy en la página de la tienda
  And ingreso a iniciar sesion
  And me logueo con mi usuario "usuario_invalido" y clave "clave_invalida"
  Then espero que no llegue a la página principal y falle el inicio de sesión