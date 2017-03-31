package com.hendisantika.gatling.simulations.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import scala.concurrent.duration._
/**
  * Created by hendisantika on 17/02/17.
  * Example Gatling load test simulating a number of users that rises up to 10 users over
  * a period of 20 seconds.
  * Run this simulation with:
  * mvn -Dgatling.simulation.name=HttpSimulation4 gatling:execute
  */
class HttpSimulation4 extends Simulation{
  val theHttpProtocolBuilder = http
    .baseURL("http://computer-database.gatling.io")

  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      http("myRequest1")
        .get("/"))

  setUp(
    /*
     * Increase the number of users that sends requests in the scenario Scenario1 to
     * ten users over a period of 20 seconds.
     */
    theScenarioBuilder.inject(rampUsers(20).over(5 seconds))
  ).protocols(theHttpProtocolBuilder)

}
