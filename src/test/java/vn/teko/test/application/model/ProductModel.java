package vn.teko.test.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedNativeQuery(name="ProductModel.selectRandomId", query="SELECT id FROM products ORDER BY RAND() LIMIT 1")
public class ProductModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="attribute_set_id")
	private int attributeSetId;

	@Column(name="brand_id")
	private int brandId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private String createdBy;

	@Lob
	private String description;

	@Column(name="display_name")
	private String displayName;

	private String highlight;

	@Column(name="master_category_id")
	private int masterCategoryId;

	private String model;

	private String name;

	@Column(name="short_name")
	private String shortName;

	private String spu;

	@Column(name="tax_id")
	private int taxId;

	private String type;

	@Column(name="unit_id")
	private int unitId;

	@Column(name="unit_po_id")
	private int unitPoId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="url_key")
	private String urlKey;

	@Column(name="variation_attributes")
	private String variationAttributes;

	public ProductModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttributeSetId() {
		return this.attributeSetId;
	}

	public void setAttributeSetId(int attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getHighlight() {
		return this.highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public int getMasterCategoryId() {
		return this.masterCategoryId;
	}

	public void setMasterCategoryId(int masterCategoryId) {
		this.masterCategoryId = masterCategoryId;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSpu() {
		return this.spu;
	}

	public void setSpu(String spu) {
		this.spu = spu;
	}

	public int getTaxId() {
		return this.taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUnitId() {
		return this.unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getUnitPoId() {
		return this.unitPoId;
	}

	public void setUnitPoId(int unitPoId) {
		this.unitPoId = unitPoId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUrlKey() {
		return this.urlKey;
	}

	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}

	public String getVariationAttributes() {
		return this.variationAttributes;
	}

	public void setVariationAttributes(String variationAttributes) {
		this.variationAttributes = variationAttributes;
	}

}