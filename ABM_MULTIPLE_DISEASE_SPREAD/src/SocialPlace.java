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

public class SocialPlace extends Agent {

  // Parameters

  // Collection Variables
  public java.util.ArrayList<Person> shoppers = new java.util.ArrayList<Person>();

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

  protected static final Color __ps278_Fill_Color = new Color(0x50000000, true);
  protected static final Color __ps279_Fill_Color = new Color(0xFFDCB200, true);
  protected static final Color __ps280_Fill_Color = new Color(0xFF806000, true);
  protected static final Color __ps281_Fill_Color = new Color(0xFFD0A200, true);
  protected static final Color __ps283_Fill_Color = new Color(0xFFFFE576, true);
  protected static final Color __ps284_Line_Color = new Color(0xFF4A3500, true);

  @AnyLogicInternalCodegenAPI
  protected static final int __ps278 = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps279 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps280 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps281 = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps282 = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps283 = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int __ps284 = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int _warehouse = 8;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 9;

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
  protected static final double[] __ps278_pointsDX_xjal() {
    return new double[] { 0.0, 4.0, 19.0, 15.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps278_pointsDY_xjal() {
    return new double[] { 0.0, 2.0, -6.0, -8.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps278_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps279_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 6.0, 11.0, 11.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps279_pointsDY_xjal() {
    return new double[] { 0.0, -6.0, -8.0, 0.0, 6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps279_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps280_pointsDX_xjal() {
    return new double[] { 0.0, 8.0, 8.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps280_pointsDY_xjal() {
    return new double[] { 0.0, 4.0, 0.0, -4.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps280_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps281_pointsDX_xjal() {
    return new double[] { 0.0, 15.0, 15.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps281_pointsDY_xjal() {
    return new double[] { 0.0, -8.0, -13.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps281_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps282_pointsDX_xjal() {
    return new double[] { 0.0, 15.0, 10.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps282_pointsDY_xjal() {
    return new double[] { 0.0, -8.0, -13.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps282_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps283_pointsDX_xjal() {
    return new double[] { 0.0, 15.0, 10.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps283_pointsDY_xjal() {
    return new double[] { 0.0, -8.0, -6.0, 2.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps283_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps284_pointsDX_xjal() {
    return new double[] { 0.0, 15.0, 15.0, 10.0, 4.0, -11.0, -11.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps284_pointsDY_xjal() {
    return new double[] { 0.0, -8.0, -13.0, -21.0, -19.0, -11.0, -6.0 };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps284_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
  }

  ShapePolyLine _ps278;
  ShapePolyLine _ps279;
  ShapePolyLine _ps280;
  ShapePolyLine _ps281;
  ShapePolyLine _ps282;
  ShapePolyLine _ps283;
  ShapePolyLine _ps284;
  ShapeGroup warehouse;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    _ps278 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        11.0,
        0.0,
        null,
        __ps278_Fill_Color,
        4,
        __ps278_pointsDX_xjal(),
        __ps278_pointsDY_xjal(),
        __ps278_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps279 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -13.0,
        6.0,
        0.0,
        null,
        __ps279_Fill_Color,
        5,
        __ps279_pointsDX_xjal(),
        __ps279_pointsDY_xjal(),
        __ps279_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps280 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -11.0,
        8.0,
        0.0,
        null,
        __ps280_Fill_Color,
        4,
        __ps280_pointsDX_xjal(),
        __ps280_pointsDY_xjal(),
        __ps280_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps281 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        11.0,
        0.0,
        null,
        __ps281_Fill_Color,
        4,
        __ps281_pointsDX_xjal(),
        __ps281_pointsDY_xjal(),
        __ps281_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps282 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        6.0,
        0.0,
        null,
        gold,
        4,
        __ps282_pointsDX_xjal(),
        __ps282_pointsDY_xjal(),
        __ps282_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps283 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -8.0,
        -2.0,
        0.0,
        null,
        __ps283_Fill_Color,
        4,
        __ps283_pointsDX_xjal(),
        __ps283_pointsDY_xjal(),
        __ps283_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    _ps284 =
      new ShapePolyLine(
        SHAPE_DRAW_2D,
        true,
        -2.0,
        11.0,
        0.0,
        __ps284_Line_Color,
        null,
        7,
        __ps284_pointsDX_xjal(),
        __ps284_pointsDY_xjal(),
        __ps284_pointsDZ_xjal(),
        true,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      warehouse =
        new ShapeGroup(
          SocialPlace.this,
          SHAPE_DRAW_2D,
          true,
          0.0,
          0.0,
          0.0,
          0.0,
          _ps278,
          _ps279,
          _ps280,
          _ps281,
          _ps282,
          _ps283,
          _ps284
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
      case __ps278:
        return _ps278;
      case __ps279:
        return _ps279;
      case __ps280:
        return _ps280;
      case __ps281:
        return _ps281;
      case __ps282:
        return _ps282;
      case __ps283:
        return _ps283;
      case __ps284:
        return _ps284;
      case _warehouse:
        return warehouse;
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
      _name_xjal = checkNameOfShape_xjal(_shape, _ps278, "_ps278");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps279, "_ps279");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps280, "_ps280");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps281, "_ps281");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps282, "_ps282");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps283, "_ps283");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, _ps284, "_ps284");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, warehouse, "warehouse");
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
      drawCollection(_panel, _g, 70, 30, 10, 0, "shoppers", shoppers);
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
    if (!_publicOnly && modelElementContains(_x, _y, 70, 30)) {
      _panel.addInspect(70, 30, this, "shoppers");
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
  public SocialPlace(
    Engine engine,
    Agent owner,
    AgentList<? extends SocialPlace> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(SocialPlace.class)) {
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
  public SocialPlace() {}

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_SocialPlace_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(
        SocialPlace.this,
        true,
        0,
        0,
        0,
        0,
        warehouse
      );
    icon = new ShapeGroup(SocialPlace.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(SocialPlace.class);
    if (isTopLevelClass_xjal(SocialPlace.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    if (isTopLevelClass_xjal(SocialPlace.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_SocialPlace_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_SocialPlace_xjal() {}

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

  public AgentList<? extends SocialPlace> getPopulation() {
    return (AgentList<? extends SocialPlace>) super.getPopulation();
  }

  public List<? extends SocialPlace> agentsInRange(double distance) {
    return (List<? extends SocialPlace>) super.agentsInRange(distance);
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -6881495869202930619L;
}
