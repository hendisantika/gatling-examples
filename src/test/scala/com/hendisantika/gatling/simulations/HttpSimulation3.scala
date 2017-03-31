package com.hendisantika.gatling.simulations.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

/**
  * Created by hendisantika on 17/02/17.
  * mvn -Dgatling.simulation.name=HttpSimulation3 gatling:execute
  */
class HttpSimulation3 extends Simulation{

  val theHttpProtocolBuilder = http
    .baseURL("http://computer-database.gatling.io")

  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      http("myRequest1")
        .get("/computers"))

  setUp(
    /*
     * Here we specify that ten simulated users shall start sending requests immediately
     * in the Scenario1 scenario.
     */
    theScenarioBuilder.inject(atOnceUsers(10))
  ).protocols(theHttpProtocolBuilder)

}
