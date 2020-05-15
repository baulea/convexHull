package de.baule.convexHull;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.vecmath.Point2d;

import org.junit.Test;

public class ConvexHullTest {

	@Test
	public void testConvexHullZeroPoints() {

		final Set<Point2d> points = new HashSet<Point2d>();

		final List<Point2d> expectedConvexHull = new ArrayList<Point2d>();

		ConvexHull implementor = new ConvexHullImplJarvisMarch();
		List<Point2d> hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);

		implementor = new ConvexHullImplGrahamScan();
		hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);

	}

	@Test
	public void testConvexHullOnePoint() {

		final Point2d p1 = new Point2d(2, -4);

		final Set<Point2d> points = new HashSet<Point2d>();
		points.add(p1);

		final List<Point2d> expectedConvexHull = new ArrayList<Point2d>();
		expectedConvexHull.add(p1);

		ConvexHull implementor = new ConvexHullImplJarvisMarch();
		List<Point2d> hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);

		implementor = new ConvexHullImplGrahamScan();
		hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);
	}

	@Test
	public void testConvexHullTwoPoints() {

		final Point2d p1 = new Point2d(2, -4);
		final Point2d p2 = new Point2d(-4, -3);

		final Set<Point2d> points = new HashSet<Point2d>();
		points.add(p1);
		points.add(p2);

		final List<Point2d> expectedConvexHullJarvisMarch = new ArrayList<Point2d>();
		expectedConvexHullJarvisMarch.add(p2);
		expectedConvexHullJarvisMarch.add(p1);

		final List<Point2d> expectedConvexHullGrahamScan = new ArrayList<Point2d>();
		expectedConvexHullGrahamScan.add(p1);
		expectedConvexHullGrahamScan.add(p2);

		ConvexHull implementor = new ConvexHullImplJarvisMarch();
		List<Point2d> hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHullJarvisMarch, hull);

		implementor = new ConvexHullImplGrahamScan();
		hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHullGrahamScan, hull);
	}

	@Test
	public void testConvexHullTwoEqualPoints() {

		final Point2d p1 = new Point2d(2, -4);
		final Point2d p2 = new Point2d(2, -4);

		final Set<Point2d> points = new HashSet<Point2d>();
		points.add(p1);
		points.add(p2);

		final List<Point2d> expectedConvexHull = new ArrayList<Point2d>();
		expectedConvexHull.add(p1);

		ConvexHull implementor = new ConvexHullImplJarvisMarch();
		List<Point2d> hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);

		implementor = new ConvexHullImplGrahamScan();
		hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHull, hull);
	}

	@Test
	public void testConvexHull() {

		final Point2d p1 = new Point2d(2, -4);
		final Point2d p2 = new Point2d(-4, -3);
		final Point2d p3 = new Point2d(8, 3);
		final Point2d p4 = new Point2d(5, -3);
		final Point2d p5 = new Point2d(2, 2);
		final Point2d p6 = new Point2d(-6, 6);
		final Point2d p7 = new Point2d(-8, -8);
		final Point2d p8 = new Point2d(-5, -9);
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
		// TODO add duplicates on hull and not on hull
		points.add(p6);
		points.add(p7);
		points.add(p8);
		points.add(p9);
		points.add(p10);
		points.add(p11);
		points.add(p12);

		final List<Point2d> expectedConvexHullJarvisMarch = new ArrayList<Point2d>();
		expectedConvexHullJarvisMarch.add(p7);
		expectedConvexHullJarvisMarch.add(p8);
		expectedConvexHullJarvisMarch.add(p10);
		expectedConvexHullJarvisMarch.add(p3);
		expectedConvexHullJarvisMarch.add(p12);
		expectedConvexHullJarvisMarch.add(p6);

		final List<Point2d> expectedConvexHullGrahamScan = new ArrayList<Point2d>();
		expectedConvexHullGrahamScan.add(p8);
		expectedConvexHullGrahamScan.add(p10);
		expectedConvexHullGrahamScan.add(p3);
		expectedConvexHullGrahamScan.add(p12);
		expectedConvexHullGrahamScan.add(p6);
		expectedConvexHullGrahamScan.add(p7);

		ConvexHull implementor = new ConvexHullImplJarvisMarch();
		List<Point2d> hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHullJarvisMarch, hull);

		implementor = new ConvexHullImplGrahamScan();
		hull = implementor.generateConvexHull(points);
		assertEquals(implementor.getClass().getName(), expectedConvexHullGrahamScan, hull);

	}
}
