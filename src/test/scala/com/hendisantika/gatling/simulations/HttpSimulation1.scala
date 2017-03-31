package com.hendisantika.gatling.simulations.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.http.config.HttpProtocolBuilder.toHttpProtocol
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

/**
  * Created by hendisantika on 17/02/17.
  * mvn -Dgatling.simulation.name=HttpSimulation1 clean gatling:execute
  */
class HttpSimulation1 extends Simulation {
  /* Place for arbitrary Scala code that is to be executed before the simulation begins. */
  before {
    println("***** My simulation is about to begin! *****")
  }

  /* Place for arbitrary Scala code that is to be executed after the simulation has ended. */
  after {
    println("***** My simulation has ended! ******")
  }

  /*
   * A HTTP protocol builder is used to specify common properties of request(s) to be sent,
   * for instance the base URL, HTTP headers that are to be enclosed with all requests etc.
   */
  val theHttpProtocolBuilder = http
    .baseURL("http://computer-database.gatling.io")

  /*
   * A scenario consists of one or more requests. For instance logging into a e-commerce
   * website, placing an order and then logging out.
   * One simulation can contain many scenarios.
   */
  /* Scenario1 is a name that describes the scenario. */
  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      /* myRequest1 is a name that describes the request. */
      http("myRequest1")
        .get("/")
    )

  /*
   * Define the load simulation.
   * Here we can specify how many users we want to simulate, if the number of users is to increase
   * gradually or if all the simulated users are to start sending requests at once etc.
   * We also specify the HTTP protocol builder to be used by the load simulation.
   */
  setUp(
    theScenarioBuilder.inject(atOnceUsers(1))
  ).protocols(theHttpProtocolBuilder)
}
