package edu.cg.models.Car;

import java.util.LinkedList;
import java.util.List;

import com.jogamp.opengl.*;

import edu.cg.algebra.Point;
import edu.cg.models.BoundingSphere;
import edu.cg.models.IIntersectable;
import edu.cg.models.IRenderable;

/**
 * A F1 Racing Car.
 *
 */
public class F1Car implements IRenderable, IIntersectable {
	// TODO : Add new design features to the car.
	// Remember to include a ReadMe file specifying what you implemented.
	Center carCenter = new Center();
	Back carBack = new Back();
	Front carFront = new Front();

	@Override
	public void render(GL2 gl) {
		carCenter.render(gl);
		gl.glPushMatrix();
		gl.glTranslated(-Specification.B_LENGTH / 2.0 - Specification.C_BASE_LENGTH / 2.0, 0.0, 0.0);
		carBack.render(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslated(Specification.F_LENGTH / 2.0 + Specification.C_BASE_LENGTH / 2.0, 0.0, 0.0);
		carFront.render(gl);
		gl.glPopMatrix();

	}

	@Override
	public String toString() {
		return "F1Car";
	}

	@Override
	public void init(GL2 gl) {

	}

	@Override
	public List<BoundingSphere> getBoundingSpheres() {
		// TODO: Return a list of bounding spheres the list structure is as follow:
		// s1 -> s2 -> s3 -> s4
		// where:
		// s1 - sphere bounding the whole car
		// s2 - sphere bounding the car front
		// s3 - sphere bounding the car center
		// s4 - sphere bounding the car back
		//
		// * NOTE:
		// All spheres should be adapted so that they are place relative to
		// the car model coordinate system.

		LinkedList<BoundingSphere> res = new LinkedList<>();
		res.add(new BoundingSphere(Specification.GLOBAL_SPHERE_RADIUS, new Point(0, Specification.C_HEIGHT * 0.7, 0)));
		List<BoundingSphere> frontSpheres = this.carFront.getBoundingSpheres();
		for (BoundingSphere sphere : frontSpheres)
			sphere.translateCenter((Specification.F_LENGTH + Specification.C_LENGTH) / 2, 0,0);
		res.addAll(frontSpheres);
		res.addAll(this.carCenter.getBoundingSpheres());
		List<BoundingSphere> backSpheres = this.carBack.getBoundingSpheres();
		for (BoundingSphere sphere : backSpheres)
			sphere.translateCenter(-(Specification.B_LENGTH + Specification.C_LENGTH) / 2, 0, 0);
		res.addAll(backSpheres);
		return res;

	}
}
