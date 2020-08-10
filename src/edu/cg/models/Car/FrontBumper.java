package edu.cg.models.Car;

import com.jogamp.opengl.GL2;

import edu.cg.algebra.Point;
import edu.cg.models.BoundingSphere;
import edu.cg.models.IRenderable;
import edu.cg.models.SkewedBox;

public class FrontBumper implements IRenderable {
	// TODO: Add fields as you like (and methods if you think they are necessary).
	private SkewedBox bumperBox = new SkewedBox(Specification.F_BUMPER_LENGTH,Specification.F_BUMPER_HEIGHT_1,
			Specification.F_BUMPER_HEIGHT_2,Specification.F_BUMPER_DEPTH,Specification.F_BUMPER_DEPTH);
	
	private SkewedBox bumperWingsBox = new SkewedBox(Specification.F_BUMPER_LENGTH, Specification.F_BUMPER_WINGS_HEIGHT_1,
            Specification.F_BUMPER_WINGS_HEIGHT_2, Specification.F_BUMPER_WINGS_DEPTH, Specification.F_BUMPER_WINGS_DEPTH);

	private BoundingSphere boundingSphere = new BoundingSphere(0.25 * Specification.F_BUMPER_WINGS_HEIGHT_1, new Point(0.0,0.0,0.0));
	
	@Override
	public void render(GL2 gl) {
		// TODO: Render the front bumper relative to it's local coordinate system.
		// Remember the dimensions of the bumper, this is important when you
		// combine the bumper with the hood.
		gl.glPushMatrix();
		Materials.SetBlackMetalMaterial(gl);
		bumperBox.render(gl);
		Materials.SetBlackMetalMaterial(gl);
		gl.glTranslated(0.0, 0.0, Specification.F_BUMPER_DEPTH / 2 + Specification.F_BUMPER_WINGS_DEPTH / 2);
		bumperWingsBox.render(gl);
		gl.glPushMatrix();
		Materials.SetRedMetalMaterial(gl);
		gl.glTranslated(0.0, 0.5 * Specification.F_BUMPER_WINGS_HEIGHT_1, 0.0);
		//set lights color
		boundingSphere.setSphereColore3d(0.7,0,0);
		boundingSphere.render(gl);
		gl.glPopMatrix();
		Materials.SetBlackMetalMaterial(gl);
		gl.glTranslated(0.0, 0.0, -(Specification.F_BUMPER_DEPTH / 2 + Specification.F_BUMPER_WINGS_DEPTH / 2) * 2);
		bumperWingsBox.render(gl);
		gl.glPushMatrix();
		Materials.SetRedMetalMaterial(gl);
		gl.glTranslated(0.0, 0.5 * Specification.F_BUMPER_WINGS_HEIGHT_1, 0.0);
		boundingSphere.render(gl);
		gl.glPopMatrix();
		gl.glPopMatrix();
	}

	@Override
	public void init(GL2 gl) {
	}

	@Override
	public String toString() {
		return "FrontBumper";
	}

}
