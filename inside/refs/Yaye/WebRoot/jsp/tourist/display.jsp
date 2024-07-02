<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>

	<title>The &lt;display:*&gt; tag library</title>
	<meta content="-1" http-equiv="Expires"/>
	<meta content="no-cache" http-equiv="Pragma"/>
	<meta content="no-cache" http-equiv="Cache-Control"/>
	<meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
	<style media="all" type="text/css">
	    @import url("css/maven-base.css");
	    @import url("css/maven-theme.css");
	    @import url("css/site.css");
	    @import url("css/screen.css");
	</style>
	<link media="print" type="text/css" href="./css/print.css" rel="stylesheet"/>
</head>

<body class="composite">
<div id="banner">
	<a id="bannerRight" href="index.jsp"><img alt="" src="img/displaytag.png"/></a>
	<div class="clear"><hr/></div>
</div>
<div id="breadcrumbs">
	<div class="xright">
		<a href="http://displaytag.sf.net">Documentation</a> |
  		<a href="index.jsp">Examples</a>
  	</div>
	<div class="clear"><hr/></div>
</div>
<div id="leftColumn">
	<div id="navcolumn">
		<h5>Examples</h5>
		<ul>
			<li><a href="example-nocolumns.jsp">Simplest case, no columns</a></li>
			<li><a href="example-columns.jsp">Columns</a></li>
			<li><a href="example-styles.jsp">Styles</a></li>
			<li><a href="example-datasource.jsp">Acquiring your List of data</a></li>
			<li><a href="example-imp-objects.jsp">Implicit objects</a></li>
			<li><a href="example-subsets.jsp">Showing subsets of data </a></li>
			<li><a href="example-autolink.jsp">Smart linking </a></li>
			<li><a href="example-decorator.jsp">Using decorators </a></li>
			<li><a href="example-decorator-link.jsp">Creating dynamic links</a></li>
			<li><a href="example-paging.jsp">Auto-paging of long lists</a></li>
			<li><a href="example-sorting.jsp">Auto-sorting by columns</a></li>
			<li><a href="example-grouping.jsp">Column grouping</a></li>
			<li><a href="example-callbacks.jsp">Using callbacks for totals</a></li>
			<li><a href="example-export.jsp">Data exporting</a></li>
			<li><a href="example-config.jsp">Config, overriding default </a></li>
			<li><a href="example-pse.jsp">All the features together</a></li>
			<li><a href="example-twotables.jsp">More tables on one page </a></li>
			<li><a href="example-nestedtables.jsp">Nested tables</a></li>
			<li><a href="example-caption-footer.jsp">Caption and footer</a></li>
			<li><a href="example-misc.jsp">Misc, odds and ends</a></li>
			<li><a href="example-new-export.jsp">WYSIWYG data exporting </a></li>
			<li><a href="example-format.jsp">Using format</a></li>
			<li><a href="example-columnlist.jsp">Dynamic Column Creation</a></li>
			<li><a href="example-rowclass.jsp">Row highlighting </a></li>
			<li><a href="example-columnsummation.jsp">Column Summation</a></li>
		</ul>
		<a id="poweredBy" href="http://validator.w3.org/check?uri=referer"><img style="border:none" width="88" height="31" alt="Valid XHTML 1.0!" src="img/valid-xhtml10.png"/></a>
	</div>
</div>
<ul id="showsource">
	<li><a href="/displaytag-examples-1.1.1/example-styles.jsp.source">View source</a></li>
</ul>

<div id="bodyColumn">
    <div id="contentBox">
    	<div class="section">
			<h2>Styles</h2>
			<ul id="stylelist">
				<li><a href="example-styles.jsp?class=isis">ISIS</a></li>
				<li><a href="example-styles.jsp?class=its">ITS</a></li>
				<li><a href="example-styles.jsp?class=mars">Mars</a></li>
				<li><a href="example-styles.jsp?class=simple">Simple</a></li>
				<li><a href="example-styles.jsp?class=report">Report</a></li>
				<li><a href="example-styles.jsp?class=mark">Mark Column</a></li>
			</ul>

			<table class="mark">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Status</th>
						<th>Comments</th>
					</tr>
				</thead>
				<tbody>
					<tr class="odd">
						<td class="idcol">13317</td>
						<td>Amet Invidunt</td>
						<td>amet-invidunt@tempor.com</td>
						<td class="tableCellError">LABORE</td>
						<td>amet At...</td>
					</tr>
					<tr class="even">
						<td class="idcol">18967</td>
						<td>Sanctus Diam</td>
						<td>sanctus-diam@gubergren.com</td>
						<td class="tableCellError">DOLOR</td>
						<td>rebum eos...</td>
					</tr>
					<tr class="odd">
						<td class="idcol">11112</td>
						<td>Amet Duo</td>
						<td>amet-duo@sed.com</td>
						<td class="tableCellError">EOS</td>
						<td>sed elitr...</td>
					</tr>
					<tr class="even">
						<td class="idcol">26806</td>
						<td>Et Consetetur</td>
						<td>et-consetetur@eos.com</td>
						<td class="tableCellError">ALIQUYAM</td>
						<td>vero consetetur...</td>
					</tr>
					<tr class="odd">
						<td class="idcol">50677</td>
						<td>Diam Invidunt</td>
						<td>diam-invidunt@kasd.com</td>
						<td class="tableCellError">ALIQUYAM</td>
						<td>et et...</td>
					</tr>
					<tr class="even">
						<td class="idcol">13176</td>
						<td>Takimata Vero</td>
						<td>takimata-vero@invidunt.com</td>
						<td class="tableCellError">ALIQUYAM</td>
						<td>et sed...</td>
					</tr>
					<tr class="odd">
						<td class="idcol">72012</td>
						<td>Sea Ea</td>
						<td>sea-ea@duo.com</td>
						<td class="tableCellError">EST</td>
						<td>At Lorem...</td>
					</tr>
					<tr class="even">
						<td class="idcol">13422</td>
						<td>Accusam Nonumy</td>
						<td>accusam-nonumy@est.com</td>
						<td class="tableCellError">SIT</td>
						<td>sanctus diam...</td>
					</tr>
					<tr class="odd">
						<td class="idcol">68229</td>
						<td>Sed Tempor</td>
						<td>sed-tempor@sea.com</td>
						<td class="tableCellError">SANCTUS</td>
						<td>nonumy no...</td>
					</tr>
					<tr class="even">
						<td class="idcol">49979</td>
						<td>Gubergren Voluptua</td>
						<td>gubergren-voluptua@magna.com</td>
						<td class="tableCellError">DOLOR</td>
						<td>sed sit...</td>
					</tr>
				</tbody>
			</table>
			<p>
			You actually have a lot of flexibility in how the table is displayed, but of
			course you should probably stay close to the defaults in most cases.  You adjust
			the look of the table via two methods, 1) pass through table and
			column attributes, and 2) Style sheets which are described below.
			</p><p>
			Click through the above links to see different style examples of the same
			basic table.  Most of the differences in appearance between the tables below
			are achieved via only stylesheet changes.
			</p>
			<h3>Html attributes</h3>
			<p>
			You can assign to the &lt;display:table&gt; tag any standard html attribute (es. cellspacing,
			cellpadding), and it will be included in the rendered table.
			</p><p>
			Likewise, you can assign to the &lt;display:column&gt; tag any standard html attribute
			and it will be included in any &lt;td&gt; tag of the rendered table.
			You can also specify a class to be used only for the column header (&lt;th&gt;) adding a
			<code>headerClass</code> attribute.
			</p><p>
			Note: the attribute <code>styleClass</code> used for the &lt;table&gt; and  &lt;column&gt; tag
			in previous version of the taglibrary is deprecated in favor of the standard html <code>class</code> attribute.
			</p><h3>Style Sheets</h3>
			<p>
			While attributes might be the most comfortable way to change the appearance
			of your table, using style sheets is more powerful.  We use style sheets to
			make the header a dark color, make rows an alternate color, and set the fonts
			within the cells to a smaller version of verdana.  As the &lt;display:table&gt;
			tag is drawing, it assigns the following class names to elements.
			</p><p>
			You can then create a style sheet and assign attributes such as font size,
			family, color, etc... to each of those class names and the table will be
			shown according to your styles.
			</p>
			<table>
				<thead>
					<tr>
						<th>class</th>
						<th>assigned to</th>
					</tr>
				</thead>
				<tbody>
					<tr class="odd">
						<td>odd</td>
						<td>assigned to the tr tag of all odd numbered data rows</td>
					</tr>
					<tr class="even">
						<td>even</td>
						<td>assigned to the tr tag of all even numbered data rows</td>
					</tr>
					<tr class="odd">
						<td>sorted</td>
						<td>assigned to the th tag of the sorted column</td>
					</tr>
					<tr class="even">
						<td>order1</td>
						<td>assigned to the th tag of the sorted column if sort order is ascending</td>
					</tr>
					<tr class="odd">
						<td>order2</td>
						<td>assigned to the th tag of the sorted column if sort order is descending</td>
					</tr>
				</tbody>
			</table>
    	</div>
  	</div>
</div>
<div class="clear"><hr/></div>
<div id="footer">
  	<div class="xright">© 2002-2006 the Displaytag team</div>
  	<div class="clear"><hr/></div>
</div>

</body>
</html>
  