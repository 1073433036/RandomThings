package usaco.NO;

public class Mowing_Mischief_2019FebPlat3 {
	public static void main(String[] args) {
		// if p, q belong to li, and xp<xq, then yp>yq otherwise q is in li+1
		// sort all points by x, process left to right
		// while processing point i, check if belong to each level
		// in each level, find point with min y and find highest level that
		// could be a parent for a new point
		// use binary search to find new levels
		// if p1 is better for q1 than p2 then it will be better for q2 as well
		// iterate through all pi to find optimal for q1, then apply to all qi
		// process all intervals one by one
		// maintain sliding windows for all points p
		// use theorem to find best solution for qk
		// update sliding windows using priority queue
	}
}
