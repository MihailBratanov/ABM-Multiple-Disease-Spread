package abm_multiple_disease_spread;

import static abm_multiple_disease_spread.SocialActivity.*;
import static com.xj.anylogic.engine.HyperArray.*;
import static com.xj.anylogic.engine.UtilitiesArray.*;
import static com.xj.anylogic.engine.presentation.UtilitiesColor.*;
import static com.xj.anylogic.engine.presentation.UtilitiesDrawing.*;
import static java.lang.Math.*;

import com.xj.anylogic.engine.*;
import com.xj.anylogic.engine.Position;
import com.xj.anylogic.engine.analysis.*;
import com.xj.anylogic.engine.connectivity.*;
import com.xj.anylogic.engine.connectivity.ResultSet;
import com.xj.anylogic.engine.connectivity.Statement;
import com.xj.anylogic.engine.markup.*;
import com.xj.anylogic.engine.markup.DensityMap;
import com.xj.anylogic.engine.markup.Network;
import com.xj.anylogic.engine.markup.PedFlowStatistics;
import com.xj.anylogic.engine.presentation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class School extends Agent {

  // Parameters

  // Collection Variables
  public java.util.ArrayList<Person> classmates = new java.util.ArrayList<Person>();

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final short _STATECHART_ELEMENT_NEXT_ID_xjal = 0;

  // View areas
  public ViewArea _origin_VA = new ViewArea(
    this,
    "[Origin]",
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.SPECIFIED_ZOOM,
    1,
    100,
    100
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("_origin_VA", this._origin_VA);
    }
    return 1 + super.getViewAreas(_output);
  }

  protected static final Color __ps268_Fill_Color = new Color(0x50000000, true);
  protected static final Color __ps269_Fill_Color = new Color(0xFF99EA00, true);
  protected static final Color __ps270_Fill_Color = new Color(0xFF83C800, true);
  protected static final Color __ps271_Fill_Color = new Color(0xFF679E00, true);
  protected static final Color __ps272_Fill_Color = new Color(0xFF416400, true);
  protected static final Color __ps273_Line_Color = new Color(0xFF679E00, true);
  protected static final Color __ps274_Line_Color = new Color(0xFF83C800, true);
  protected static final Color __ps275_Line_Color = new Color(0xFF203200, true);

  @AnyLogicInternalCodegenAPI
  protected static final int __ps268 = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps269 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps270 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps271 = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps272 = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps273 = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps274 = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps275 = 8;

  @AnyLogicInternalCodegenAPI
  protected static final int _store = 9;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 10;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDX_xjal() {
    return new double[] { 0.0, 3.0, 12.0, 10.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDY_xjal() {
    return new double[] { 0.0, 2.0, -3.0, -5.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 0.0, -10.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDY_xjal() {
    return new double[] { 0.0, -5.0, -8.0, -5.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 10.0, 10.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDY_xjal() {
    return new double[] { 0.0, -7.0, -2.0, 5.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDY_xjal() {
    return new double[] { 0.0, -5.0, -10.0, -7.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDX_xjal() {
    return new double[] { 0.0, 8.0, 15.0, 15.0, 8.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDY_xjal() {
    return new double[] { 0.0, 3.0, 0.0, -3.0, 0.0, -3.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps275_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 0.0, -10.0, -10.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps275_pointsDY_xjal() {
    return new double[] { 0.0, -5.0, -10.0, -15.0, -10.0, -5.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps275_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  ShapePolyLine _ps268;
  ShapePolyLine _ps269;
  ShapePolyLine _ps270;
  ShapePolyLine _ps271;
  ShapePolyLine _ps272;
  ShapeLine _ps273;
  ShapeLine _ps274;
  ShapePolyLine _ps275;
  ShapeGroup store;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    _ps268 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        10.0,
        0.0,
        null,
        __ps268_Fill_Color,
        4,
        __ps268_pointsDX_xjal(),
        __ps268_pointsDY_xjal(),
        __ps268_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps269 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        3.0,
        0.0,
        null,
        __ps269_Fill_Color,
        4,
        __ps269_pointsDX_xjal(),
        __ps269_pointsDY_xjal(),
        __ps269_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps270 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -10.0,
        5.0,
        0.0,
        null,
        __ps270_Fill_Color,
        4,
        __ps270_pointsDX_xjal(),
        __ps270_pointsDY_xjal(),
        __ps270_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps271 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        10.0,
        0.0,
        null,
        __ps271_Fill_Color,
        4,
        __ps271_pointsDX_xjal(),
        __ps271_pointsDY_xjal(),
        __ps271_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps272 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -8.0,
        5.0,
        0.0,
        null,
        __ps272_Fill_Color,
        6,
        __ps272_pointsDX_xjal(),
        __ps272_pointsDY_xjal(),
        __ps272_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps273 =
      new ShapeLine(
        SHAPE_DRAW_2D,
        true,
        2.0,
        8.0,
        0.0,
        __ps273_Line_Color,
        0.0,
        -5.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    _ps274 =
      new ShapeLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        8.0,
        0.0,
        __ps274_Line_Color,
        0.0,
        -5.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    _ps275 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        0.0,
        10.0,
        0.0,
        __ps275_Line_Color,
        null,
        6,
        __ps275_pointsDX_xjal(),
        __ps275_pointsDY_xjal(),
        __ps275_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      store =
        new ShapeGroup(
          School.this,
          SHAPE_DRAW_2D,
          true,
          0.0,
          0.0,
          0.0,
          0.0,
          _ps268,
          _ps269,
          _ps270,
          _ps271,
          _ps272,
          _ps273,
          _ps274,
          _ps275
        );
    }
  }

  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

  ShapeTopLevelPresentationGroup presentation;
  ShapeGroup icon;

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape(int _shape) {
    switch (_shape) {
      case _presentation:
        return presentation;
      case _icon:
        return icon;
      case __ps268:
        return _ps268;
      case __ps269:
        return _ps269;
      case __ps270:
        return _ps270;
      case __ps271:
        return _ps271;
      case __ps272:
        return _ps272;
      case __ps273:
        return _ps273;
      case __ps274:
        return _ps274;
      case __ps275:
        return _ps275;
      case _store:
        return store;
      default:
        return super.getPersistentShape(_shape);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal(Object _shape) {
    try {
      if (_shape == null) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, presentation, "presentation");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, icon, "icon");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps268, "_ps268");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps269, "_ps269");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps270, "_ps270");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps271, "_ps271");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps272, "_ps272");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps273, "_ps273");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps274, "_ps274");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps275, "_ps275");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, store, "store");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawCollection(_panel, _g, 40, 30, 10, 0, "classmates", classmates);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (_publicOnly) {
      return;
    }
    drawLinkToContainer(_panel, _g, 50, -100, 10, 0, "main", main);
    drawLinkToAgent(
      _panel,
      _g,
      50,
      -50,
      15,
      0,
      "connections",
      true,
      connections
    );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    super.drawModelElements(_panel, _g, _publicOnly, true);
    drawModelElements_CollectionVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_AgentLinks_xjal(_panel, _g, _publicOnly, _isSuperClass);
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (modelElementContains(_x, _y, 50, -100)) {
      if (_clickCount == 2) {
        _panel.browseAgent_xjal(50, -100, this, "main");
      } else {
        _panel.addInspect(50, -100, this, "main");
      }
      return true;
    }
    if (modelElementContains(_x, _y, 50, -50)) {
      _panel.addInspect_xjal(
        50,
        -50,
        this,
        "connections",
        Panel.INSPECT_CONNECTIONS_xjal
      );
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_CollectionVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, 40, 30)) {
      _panel.addInspect(40, 30, this, "classmates");
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (
      onClickModelAt_AgentLinks_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_CollectionVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    return super.onClickModelAt(_panel, _x, _y, _clickCount, _publicOnly, true);
  }

  /**
   * Constructor
   */
  public School(
    Engine engine,
    Agent owner,
    AgentList<? extends School> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(School.class)) {
      instantiateBaseStructure_xjal();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public School() {}

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_School_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(School.this, true, 0, 0, 0, 0, store);
    icon = new ShapeGroup(School.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(School.class);
    if (isTopLevelClass_xjal(School.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    if (isTopLevelClass_xjal(School.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_School_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_School_xjal() {}

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if (owner instanceof Main) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient abm_multiple_disease_spread.Main main;

  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl(
    false,
    black,
    1.0,
    LINE_STYLE_SOLID,
    ARROW_NONE,
    0.0
  );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(
    this,
    _connections_commonAnimationSettings_xjal
  );

  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }

  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(
    boolean _underAgents_xjal,
    LinkToAgentAnimator _animator_xjal
  ) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if (_underAgents_xjal) {
      _animator_xjal.drawLink(this, connections, true, true);
    }
  }

  public AgentList<? extends School> getPopulation() {
    return (AgentList<? extends School>) super.getPopulation();
  }

  public List<? extends School> agentsInRange(double distance) {
    return (List<? extends School>) super.agentsInRange(distance);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -6295986686278552553L;
}
