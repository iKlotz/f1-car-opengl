package edu.cg.models.Car;

import java.util.LinkedList;
import java.util.List;

import com.jogamp.opengl.GL2;

import edu.cg.algebra.Point;
import edu.cg.models.BoundingSphere;
import edu.cg.models.IIntersectable;
import edu.cg.models.IRenderable;

public class Front implements IRenderable, IIntersectable {
	// TODO: Add necessary fields (e.g. the bumper).
    private FrontBumper bumper = new FrontBumper();
	private FrontHood hood = new FrontHood();
	private PairOfWheels wheels = new PairOfWheels();

	@Override
	public void render(GL2 gl) {
		// TODO: Render the BUMPER. Look at how we place the front and the wheels of
		// the car.

		gl.glPushMatrix();	
		gl.glTranslated(-Specification.F_LENGTH / 2.0 + Specification.F_HOOD_LENGTH / 2.0, 0.0, 0.0);
		hood.render(gl);
		// Render the wheels.
		gl.glTranslated(Specification.F_HOOD_LENGTH / 2.0 - 1.25 * Specification.TIRE_RADIUS,
				0.5 * Specification.TIRE_RADIUS, 0.0);
		wheels.render(gl);
		//added by me
		gl.glTranslated(Specification.F_HOOD_LENGTH / 2.0 - .9 * Specification.TIRE_RADIUS, -(Specification.TIRE_RADIUS / 2), 0.0);
		bumper.render(gl);
	
		gl.glPopMatrix();
	}

	@Override
	public void init(GL2 gl) {
	}

	@Override
	public List<BoundingSphere> getBoundingSpheres() {
		// TODO: Return a list of bounding spheres the list structure is as follow:
		// s1
		// where:
		// s1 - sphere bounding the car front
		double radius = Specification.FRONT_SPHERE_RADIUS;
		Point center = new Point(0.0,	Specification.F_HEIGHT / 2 , 0.0);
		BoundingSphere sphere = new BoundingSphere(radius, center);
		sphere.setSphereColore3d(1, 0, 0);
		LinkedList<BoundingSphere> res = new LinkedList<BoundingSphere>();
		res.add(sphere);
		
		return res;
	}

	@Override
	public String toString() {
		return "CarFront";
	}
}
