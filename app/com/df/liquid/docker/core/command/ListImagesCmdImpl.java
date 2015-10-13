package com.df.liquid.docker.core.command;



import java.util.List;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.ListImagesCmd;
import com.df.liquid.docker.api.model.ChangeLog;
import com.df.liquid.docker.api.model.Image;

import static com.google.common.base.Preconditions.checkNotNull;



/**
 * List images
 *
 * @param showAll - Show all images (by default filter out the intermediate images used to build)
 * @param filters - a json encoded value of the filters (a map[string][]string) to process on the images list.
 */
public class ListImagesCmdImpl extends AbstrDockerCmd<ListImagesCmd, List<Image>> implements ListImagesCmd  {

	private String filters;

	private boolean showAll = false;

	public ListImagesCmdImpl(ListImagesCmd.Exec exec) {
		super(exec);
	}

    @Override
	public String getFilters() {
        return filters;
    }

    @Override
	public boolean hasShowAllEnabled() {
        return showAll;
    }

    @Override
	public ListImagesCmd withShowAll(boolean showAll) {
		this.showAll = showAll;
		return this;
	}

	@Override
	public ListImagesCmd withFilters(String filter) {
		checkNotNull(filter, "filters have not been specified");
		this.filters = filter;
		return this;
	}

    @Override
    public String toString() {
        return new StringBuilder("images ")
            .append(showAll ? "--all=true" : "")
            .append(filters != null ? "--filter " + filters : "")
            .toString();
    }

 /*   @Override
    public List<Image> exec() throws NotFoundException {
    	return super.exec();
    }
*/
}

