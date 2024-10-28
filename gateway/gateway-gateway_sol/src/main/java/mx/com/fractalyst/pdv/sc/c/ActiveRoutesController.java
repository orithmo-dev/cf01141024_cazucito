package mx.com.fractalyst.pdv.sc.c;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ActiveRoutesController {

	private final RouteLocator routeLocator;

	public ActiveRoutesController(RouteLocator routeLocator) {
		this.routeLocator = routeLocator;
	}

	@GetMapping("/active-routes")
	public Flux<Route> getActiveRoutes() {
		return routeLocator.getRoutes();
	}
}
