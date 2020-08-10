package edu.cg.models.Car;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import edu.cg.models.IRenderable;

public class PairOfPipes implements IRenderable {
    private final Pipe pipe = new Pipe();

    @Override
    public void render(GL2 gl) {
        // Render Pipes:
        gl.glPushMatrix();
        GLU glu = new GLU();
        GLUquadric quad = glu.gluNewQuadric();
        gl.glTranslated(-Specification.B_LENGTH / 2 - 0.02, 0.04, 0.03); //
        pipe.render(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslated(-Specification.B_LENGTH / 2 - 0.02, 0.04, -0.03); //
        pipe.render(gl);
        gl.glPopMatrix();
        glu.gluDeleteQuadric(quad);
    }

    @Override
    public void init(GL2 gl) {
    }

    @Override
    public String toString() {
        return "Pipes";
    }

}
