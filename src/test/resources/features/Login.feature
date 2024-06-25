Feature: Feature login a padok

  Descripcion del Feature: Princiopal objetivo es loguear a padok y ver dashboard

    # Background: Valida acceso a demoqa.com
    #     Given navego a dev.padok.cl

  @LoginUser
  Scenario: Valida ingreso a dashboard
    Given navego a dev.padok.cl
    When hago click en menu lateral superior
    And hago click en Sign in with Email
    And escribo usuario y clave
    And hago click en boton iniciar sesion
    Then verifico que exista mensaje de Dashboard
    And verifico que exista texto Monto a liquidar
    And verifico que exista texto Total recaudado
    And verifico que exista texto Monto a Descuentos


  @OtroTag
  Scenario: Valida ingreso a dashboard
    Given navego a dev.padok.cl