
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
  
    <html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
  <title>The &lt;display:*> tag library</title>
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
  <div class="xright"><a href="http://displaytag.sf.net">Documentation</a> |
    <a href="index.jsp">Examples</a>
  </div><div class="clear"><hr/></div>
  </div>
  <div id="leftColumn"><div id="navcolumn"><h5>Examples</h5><ul><li><a href="example-nocolumns.jsp">Simplest case, no columns</a></li><li><a href="example-columns.jsp">Columns</a></li><li><a href="example-styles.jsp">Styles</a></li><li><a href="example-datasource.jsp">Acquiring your List of data</a></li><li><a href="example-imp-objects.jsp">Implicit objects</a></li><li><a href="example-subsets.jsp">Showing subsets of data </a></li><li><a href="example-autolink.jsp">Smart linking </a></li><li><a href="example-decorator.jsp">Using decorators </a></li><li><a href="example-decorator-link.jsp">Creating dynamic links</a></li><li><a href="example-paging.jsp">Auto-paging of long lists</a></li><li><a href="example-sorting.jsp">Auto-sorting by columns</a></li><li><a href="example-grouping.jsp">Column grouping</a></li><li><a href="example-callbacks.jsp">Using callbacks for totals</a></li><li><a href="example-export.jsp">Data exporting</a></li><li><a href="example-config.jsp">Config, overriding default </a></li><li><a href="example-pse.jsp">All the features together</a></li><li><a href="example-twotables.jsp">More tables on one page </a></li><li><a href="example-nestedtables.jsp">Nested tables</a></li><li><a href="example-caption-footer.jsp">Caption and footer</a></li><li><a href="example-misc.jsp">Misc, odds and ends</a></li><li><a href="example-new-export.jsp">WYSIWYG data exporting </a></li><li><a href="example-format.jsp">Using format</a></li><li><a href="example-columnlist.jsp">Dynamic Column Creation</a></li><li><a href="example-rowclass.jsp">Row highlighting </a></li><li><a href="example-columnsummation.jsp">Column Summation</a></li></ul><a id="poweredBy" href="http://validator.w3.org/check?uri=referer"><img style="border:none" width="88" height="31" alt="Valid XHTML 1.0!" src="img/valid-xhtml10.png"/></a></div></div><ul id="showsource"><li><a href="/displaytag-examples-1.1.1/example-pse.jsp.source">View source</a></li></ul>
    <div id="bodyColumn">
      <div id="contentBox">
      <div class="section">
  <h2>Paging + sorting + grouping + exporting working together</h2><span class="pagebanner">20 items found, displaying 1 to 8.</span><span class="pagelinks">[First/Prev] <strong>1</strong>, <a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=2" title="Go to page 2">2</a>, <a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=3" title="Go to page 3">3</a> [<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=2">Next</a>/<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=3">Last</a>]</span>
<table>
<thead>
<tr>
<th class="sortable">
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-o=2&amp;d-49653-p=1&amp;d-49653-s=0">CITY</a></th>
<th class="sortable">
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-o=2&amp;d-49653-p=1&amp;d-49653-s=1">PROJECT</a></th>
<th>HOURS</th>
<th>TASK</th></tr></thead>
<tbody>
<tr class="odd">
<td>Neapolis</td>
<td>Army</td>
<td>440.0</td>
<td>voluptua sadipscing Stet diam </td></tr>
<tr class="even">
<td>Roma</td>
<td>Army</td>
<td>864.0</td>
<td>Lorem consetetur ut dolore </td></tr>
<tr class="odd">
<td></td>
<td>Arts</td>
<td>143.0</td>
<td>ea amet dolor kasd </td></tr>
<tr class="even">
<td>Neapolis</td>
<td>Arts</td>
<td>428.0</td>
<td>elitr kasd ea voluptua </td></tr>
<tr class="odd">
<td>Roma</td>
<td>Arts</td>
<td>718.0</td>
<td>sed eos sea diam </td></tr>
<tr class="even">
<td>Olympia</td>
<td>Arts</td>
<td>781.0</td>
<td>dolore takimata eos eos </td></tr>
<tr class="odd">
<td></td>
<td>Gladiators</td>
<td>83.0</td>
<td>justo duo et diam </td></tr>
<tr class="even">
<td>Neapolis</td>
<td>Gladiators</td>
<td>89.0</td>
<td>gubergren consetetur et consetetur </td></tr></tbody></table><div class="exportlinks">Export options: 
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=1&amp;6578706f7274=1&amp;d-49653-e=1"><span class="export csv">CSV </span></a>|
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=1&amp;6578706f7274=1&amp;d-49653-e=2"><span class="export excel">Excel </span></a>|
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=1&amp;6578706f7274=1&amp;d-49653-e=3"><span class="export xml">XML </span></a>|
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=1&amp;6578706f7274=1&amp;d-49653-e=5"><span class="export pdf">PDF </span></a>|
<a href="/displaytag-examples-1.1.1/example-pse.jsp?d-49653-p=1&amp;6578706f7274=1&amp;d-49653-e=6"><span class="export rtf">RTF </span></a></div><p>What happen if you put everything together, sorting the full list (attribute <code>sort="list"</code>), using
  pagination and exporting?</p><p>When sorting is enabled on the full list, the page number is automatically reset if you change the sorted column or
  the sort order.</p><p>Exported documents contain the full list. Grouping is not applied in the exported documents.</p>
    </div></div></div>
  <div class="clear"><hr/></div><div id="footer"><div class="xright">© 2002-2006 the Displaytag team</div><div class="clear"><hr/></div></div>
    </body></html>
  