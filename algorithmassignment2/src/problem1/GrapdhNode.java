package problem1;

public class GrapdhNode {
	Integer vertex;
	Integer weight;

	/**
	 * @param vertex
	 * @param weight
	 */
	public GrapdhNode(Integer vertex, Integer weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}

	/**
	 * @return the vertex
	 */
	public Integer getVertex() {
		return vertex;
	}

	/**
	 * @param vertex
	 *            the vertex to set
	 */
	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GrapdhNode [vertex=" + vertex + ", weight=" + weight + "]";
	}

}
