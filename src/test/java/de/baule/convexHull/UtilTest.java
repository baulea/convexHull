package de.baule.convexHull;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import javax.vecmath.Point2d;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testComputeLeftmostLowest() {

		final Point2d p1 = new Point2d(2, -4);
		final Point2d p2 = new Point2d(-4, -3);
		final Point2d p3 = new Point2d(8, 3);
		final Point2d p4 = new Point2d(5, -3);
		final Point2d p5 = new Point2d(2, 2);
		final Point2d p6 = new Point2d(-6, 6);
		final Point2d p7 = new Point2d(-8, -8);
		final Point2d p8 = new Point2d(-8, -9);
		final Point2d p9 = new Point2d(5, 5);
		final Point2d p10 = new Point2d(3, -7);
		final Point2d p11 = new Point2d(-6, -2);
		final Point2d p12 = new Point2d(1, 9);

		final Set<Point2d> points = new HashSet<Point2d>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p5); // duplicate
		points.add(p8);
		points.add(p9);
		points.add(p10);
		points.add(p11);
		points.add(p8); // duplicate
		points.add(p12);

		assertEquals(p8, Util.computeLeftmostLowest(points));
	}

	@Test
	public void testComputeLowestLeftmost() {

		final Point2d p1 = new Point2d(2, -4);
		final Point2d p2 = new Point2d(-4, -3);
		final Point2d p3 = new Point2d(8, 3);
		final Point2d p4 = new Point2d(5, -3);
		final Point2d p5 = new Point2d(2, 2);
		final Point2d p6 = new Point2d(-6, 6);
		final Point2d p7 = new Point2d(-8, -10);
		final Point2d p8 = new Point2d(-8, -9);
		final Point2d p9 = new Point2d(5, 5);
		final Point2d p10 = new Point2d(3, -7);
		final Point2d p11 = new Point2d(-6, -2);
		final Point2d p12 = new Point2d(1, 9);

		final Set<Point2d> points = new HashSet<Point2d>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p5); // duplicate
		points.add(p8);
		points.add(p9);
		points.add(p10);
		points.add(p11);
		points.add(p8); // duplicate
		points.add(p12);

		assertEquals(p7, Util.computeLowestLeftmost(points));
	}

	@Test
	public void testOrientation() {
		assertEquals(0,
				Util.orientation(new Point2d(2, 3), new Point2d(-6, -9), new Point2d(4, 6)));

		// p1.equals(p2)
		assertEquals(0,
				Util.orientation(new Point2d(-6, -9), new Point2d(-6, -9), new Point2d(4, 6)));

		// p2.equals(p3)
		assertEquals(0,
				Util.orientation(new Point2d(2, 3), new Point2d(-6, -9), new Point2d(-6, -9)));

		// p1.equals(p3)
		assertEquals(0,
				Util.orientation(new Point2d(4, 6), new Point2d(-6, -9), new Point2d(4, 6)));

		// p1.equals(p2) && p2.equals(p3)
		assertEquals(0, Util.orientation(new Point2d(2, 3), new Point2d(2, 3), new Point2d(2, 3)));

		assertEquals(-1,
				Util.orientation(new Point2d(8, 3), new Point2d(-6, -6), new Point2d(-8, -8)));

		assertEquals(1,
				Util.orientation(new Point2d(1, 9), new Point2d(3, -7), new Point2d(-8, -7)));
	}

}
