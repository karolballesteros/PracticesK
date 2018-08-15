Feature: Compra tours

  Scenario Outline: Compra de tiquetes de tours
    Given Los clientes necesitan comprar "<tipoCompra>"
    And poder seleccionar la ciudad a la que desean asistir de vacaciones "<ciudadVacaciones>"
    And poder indicar o no las fechas para asistir a sus vacaciones "<fechaVacaciones>"
    And poder indicar las personas que los acompañara en sus vacaciones"<cantidadPersona>"
    And poder indicar el objetivo de su estadia"<objVisita>"
    Then Validar la información del destino y realizar el pago
    And poder indicar el medio de pago con el que desea realizar el pago"<medioPago>"

    Examples:
      | tipoCompra | ciudadVacaciones | fechaVacaciones | cantidadPersona | objVisita | medioPago       |
      | tours      | Dubai            | 18/09/2019      | 1               | Private   | tarjeta credito |