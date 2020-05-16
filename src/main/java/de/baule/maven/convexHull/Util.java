package de.baule.maven.convexHull;

import java.util.Set;

import javax.vecmath.Point2d;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

class Util {

	/**
	 * get the leftmost-lowest point from a set of points
	 *
	 * @param points
	 *            set of points
	 * @return leftmost-lowest point
	 */
	@Nullable
	static Point2d computeLeftmostLowest(@NonNull final Set<Point2d> points) {
		Point2d leftmostLowest = null;
		for (final Point2d point : points) {
			if (leftmostLowest == null || point.x < leftmostLowest.x
					|| (point.x == leftmostLowest.x && point.y < leftmostLowest.y)) {
				leftmostLowest = point;
			}
		}
		return leftmostLowest;
	}

	/**
	 * get the lowest-leftmost point from a set of points
	 *
	 * @param points
	 *            set of points
	 * @return lowest-leftmost point
	 */
	@Nullable
	static Point2d computeLowestLeftmost(@NonNull final Set<Point2d> points) {
		Point2d lowestLeftmost = null;
		for (final Point2d point : points) {
			if (lowestLeftmost == null || point.y < lowestLeftmost.y
					|| (point.y == lowestLeftmost.y && point.x < lowestLeftmost.x)) {
				lowestLeftmost = point;
			}
		}
		return lowestLeftmost;
	}

	/**
	 * calculate orientation of 3 points
	 *
	 * @param p1
	 *            point1
	 * @param p2
	 *            point2
	 * @param p3
	 *            point3
	 * @return 0 if (p1,p2,p3) are collinear; 1 if (p1,p2,p3) are oriented
	 *         clockwise; -1 if (p1,p2,p3) are oriented counter-clockwise
	 */
	static int orientation(@NonNull final Point2d p1, @NonNull final Point2d p2,
			@NonNull final Point2d p3) {

		final double val = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);
		return val == 0 ? 0 : val < 0 ? -1 : 1;
	}
}
