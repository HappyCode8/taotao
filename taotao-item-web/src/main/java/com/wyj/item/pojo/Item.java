package com.wyj.item.pojo;

import com.wyj.pojo.TbItem;

public class Item extends TbItem{
	private static final long serialVersionUID = 1L;

	public String[] getImages() {
        String image = this.getImage();
        if (image != null && !"".equals(image)) {
            return image.split(",");
        }
        return null;
    }

    public Item() {

    }

    public Item(TbItem tbItem) {
        this.setBarcode(tbItem.getBarcode());
        this.setCid(tbItem.getCid());
        this.setCreated(tbItem.getCreated());
        this.setId(tbItem.getId());
        this.setImage(tbItem.getImage());
        this.setNum(tbItem.getNum());
        this.setPrice(tbItem.getPrice());
        this.setSellPoint(tbItem.getSellPoint());
        this.setStatus(tbItem.getStatus());
        this.setTitle(tbItem.getTitle());
        this.setUpdated(tbItem.getUpdated());
    }
}
