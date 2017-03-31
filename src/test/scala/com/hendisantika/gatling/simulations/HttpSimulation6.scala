package com.hendisantika.gatling.simulations.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

/**
  * Created by hendisantika on 17/02/17.
  * Example Gatling load test that sends one HTTP GET requests to a bad URL.
  * The resulting HTTP status code should be 404, which is verified in the simulation.
  * In addition, we also verify that the maximum response time during the simulation is less than 200 ms.
  * Run this simulation with:
  * mvn -Dgatling.simulation.name=HttpSimulation6 gatling:execute
  */
class HttpSimulation6 extends Simulation{
  val theHttpProtocolBuilder = http
    .baseURL("http://computer-database.gatling.io")

  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      http("Bad Request")
        .get("/unknown")
        /*
         * Check the response of this request. It should be a HTTP status 404.
         * Since the expected result is 404, the request will be verified as being OK
         * and the simulation will thus succeed.
         */
        .check(
        status.is(404)
      )
    )

  setUp(
    theScenarioBuilder.inject(atOnceUsers(1))
  )
    /*
     * This asserts that, for all the requests in all the scenarios in the simulation
     * the maximum response time should be less than 200 ms.
     * If this is not the case when the simulation runs, the simulation will considered to have failed.
     */
    .assertions(
    global.responseTime.max.lessThan(500),
    forAll.failedRequests.count.lessThan(5),
    details("Bad Request").successfulRequests.percent.greaterThan(90)
  )
    .protocols(theHttpProtocolBuilder)

}
