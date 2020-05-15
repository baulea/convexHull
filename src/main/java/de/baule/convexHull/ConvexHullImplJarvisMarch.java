package de.baule.convexHull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.vecmath.Point2d;

import org.eclipse.jdt.annotation.NonNull;

/**
 * https://en.wikipedia.org/wiki/Gift_wrapping_algorithm
 *
 * https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
 */
public class ConvexHullImplJarvisMarch implements ConvexHull {

	@Override
	@NonNull
	public List<Point2d> generateConvexHull(final @NonNull Set<Point2d> points) {

		final List<Point2d> convexHull = new ArrayList<>();

		final Point2d firstHullPoint = Util.computeLeftmostLowest(points);
		if (firstHullPoint != null) {
			// the convex hull is built starting with the leftmost-lowest point
			// and continues counter-clockwise
			Point2d prevPoint = firstHullPoint;
			do {
				convexHull.add(prevPoint);
				Point2d nextPoint = null;
				for (final Point2d point : points) {
					// search next point from set of all points that
					// - is not the previous one
					// - and has the smallest curve
					// If this next point is equal to the one that started the
					// convex hull, we're done.
					if (point.equals(prevPoint)) {
						continue;
					}
					if (nextPoint == null) {
						nextPoint = point;
					} else {
						final int orientation = Util.orientation(prevPoint, point, nextPoint);
						if (orientation < 0 || (orientation == 0
								&& prevPoint.distance(nextPoint) < prevPoint.distance(point))) {
							nextPoint = point;
						}
					}
				}
				prevPoint = nextPoint;
			} while (prevPoint != null && !firstHullPoint.equals(prevPoint));
		}

		return convexHull;
	}

}
