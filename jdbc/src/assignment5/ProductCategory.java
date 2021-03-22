package assignment5;

public class ProductCategory {
	String categoryId;
	String categoryTitle;
	int childCount;

	/**
	 * @param categoryId
	 * @param categoryTitle
	 * @param childCount
	 */
	public ProductCategory(String categoryId, String categoryTitle,
			int childCount) {
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.childCount = childCount;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return categoryTitle;
	}

	/**
	 * @param categoryTitle
	 *            the categoryTitle to set
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	/**
	 * @return the childCount
	 */
	public int getChildCount() {
		return childCount;
	}

	/**
	 * @param childCount
	 *            the childCount to set
	 */
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "categoryId=" + categoryId + ", categoryTitle="
				+ categoryTitle + ", childCount=" + childCount + "\n";
	}

}
