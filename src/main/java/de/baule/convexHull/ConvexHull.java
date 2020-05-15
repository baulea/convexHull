package de.baule.convexHull;

import java.util.List;
import java.util.Set;

import javax.vecmath.Point2d;

import org.eclipse.jdt.annotation.NonNull;

public interface ConvexHull {
	/**
	 * Generate the convex hull from a set of points
	 * https://en.wikipedia.org/wiki/Convex_hull
	 *
	 * @param points
	 *            set of points
	 * @return convex hull as a list of points. The convex hull is formed by a
	 *         path from each point in the list to its successor, and from the
	 *         last point in the list back to the first point in the list.
	 */
	@NonNull
	List<Point2d> generateConvexHull(final @NonNull Set<Point2d> points);
}
