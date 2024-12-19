Feature: Product - Store
  @productos
# correo: taiperojasjavier@gmail.com
# contraseña: @eiou123aeiou

  Scenario: Validación del precio de un producto con usuario y contraseña válidos
    Given estoy en la página de la tienda
    And ingreso a iniciar sesion
    And me logueo con mi usuario "taiperojasjavier@gmail.com" y clave "@eiou123aeiou"
    When navego a la categoria "CLOTHES" y subcategoria Men
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

